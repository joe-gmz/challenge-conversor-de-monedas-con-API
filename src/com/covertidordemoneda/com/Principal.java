package com.covertidordemoneda.com;
import com.google.gson.Gson;
import java.net.http.HttpClient;

public class Principal {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();
        ConversorDivisasCliente clienteHttp = new ConversorDivisasCliente(httpClient, gson);
        ServicioDeConversion servicio = new ServicioDeConversion(clienteHttp);
        MenuUsuario implementacion = new MenuUsuario(servicio);
        implementacion.mostrarMenu();
    }
}

