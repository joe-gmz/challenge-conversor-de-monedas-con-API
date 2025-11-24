package com.covertidordemoneda.com;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record TasaDeCambioRespuesta(
        @SerializedName("result") String resultado,
        @SerializedName("base_code") String baseCode,
        @SerializedName("conversion_rates") Map<String, Double> conversionRates
) { }
