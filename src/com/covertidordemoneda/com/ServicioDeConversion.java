package com.covertidordemoneda.com;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ServicioDeConversion {
    private final ConversorDivisasCliente apiCliente;

    public ServicioDeConversion(ConversorDivisasCliente apiCliente) {
        this.apiCliente = apiCliente;
    }

    public double convertir(String mondedaBase, String monedaDestino, double cantidad)
            throws IOException, InterruptedException {
        TasaDeCambioRespuesta tasas = apiCliente.obtenerTasas(mondedaBase);
        Map<String, Double> mapearTasa = tasas.conversionRates();

        Double tasaDestino = mapearTasa.get(monedaDestino);
        if (tasaDestino == null) {
            throw new IllegalArgumentException("No se encontró la tasa para la moneda de destino: " + monedaDestino);
        }
        return cantidad * tasaDestino;

    }
}
