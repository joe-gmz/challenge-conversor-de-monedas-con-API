package com.covertidordemoneda.com;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDivisasCliente {
    private static final String API_KEY = "03ced80558b0e206d953e7f0";
    private static final String BASE_API_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient httpClient;
    private final Gson gson;

    public ConversorDivisasCliente(HttpClient httpClient, Gson gson) {
        this.httpClient = httpClient;
        this.gson = gson;
    }

    public TasaDeCambioRespuesta obtenerTasas(String monedaBase) throws IOException, InterruptedException {
        String urlCompleta = BASE_API_URL + API_KEY + "/latest/" + monedaBase;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlCompleta))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error al llamar la API: " + response.statusCode());
        }
        String respuestaJson = response.body();
        TasaDeCambioRespuesta tasaResp = gson.fromJson(respuestaJson, TasaDeCambioRespuesta.class);
        return tasaResp;
    }
}
