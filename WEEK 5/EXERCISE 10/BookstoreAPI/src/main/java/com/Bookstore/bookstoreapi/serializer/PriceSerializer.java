package com.Bookstore.bookstoreapi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceSerializer extends JsonSerializer<Double> {

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN")); // You can adjust the locale as needed
        currencyFormat.setMinimumFractionDigits(2);
        currencyFormat.setMaximumFractionDigits(2);

        String formattedValue = currencyFormat.format(value);
        gen.writeString(formattedValue);
    }
}
