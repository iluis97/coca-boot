package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToStringWithTimezoneSerializer extends JsonSerializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // 使用系统默认时区，也可以指定其他时区
        ZonedDateTime zonedDateTime = value.atZone(ZoneId.systemDefault());
        String formattedDateTime = zonedDateTime.format(formatter);
        gen.writeString(formattedDateTime);
    }
}
