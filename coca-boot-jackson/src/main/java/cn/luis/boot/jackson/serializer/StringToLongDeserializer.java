package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class StringToLongDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            return null;  // or throw a custom exception
        }
    }
}
