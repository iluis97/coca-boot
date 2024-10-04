package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTimeWithTimezoneDeserializer extends JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText();
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(date, formatter);
        // 返回 LocalDateTime，丢弃时区信息
        return zonedDateTime.toLocalDateTime();
    }
}
