package com.example.demows;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class CurrencyController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> getGurrencyData() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
        .url("https://api.apilayer.com/currency_data/timeframe?start_date=2023-05-27&end_date=2023-06-05&source=KZT&currencies=EUR,RUB,USD")
        .addHeader("apikey", "PiHG0JZmJe50rvcWdhgnAnzcXB5v5JzC")
        .method("GET", null)
        .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            return ResponseEntity.ok(responseBody);
        }
    }
}
