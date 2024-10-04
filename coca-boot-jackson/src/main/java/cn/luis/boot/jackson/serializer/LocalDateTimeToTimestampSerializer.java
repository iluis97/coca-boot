package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToTimestampSerializer extends JsonSerializer<LocalDateTime> {


    private static final DateTimeFormatter FORMATTER_YYYY_MM_DD_HHMMSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_HHMMSS = DateTimeFormatter.ofPattern("HH:mm:ss");


    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            // 获取系统默认时区
            ZoneId zoneId = ZoneId.systemDefault();
            // 获取该时区在指定时间点的偏移量
            ZoneOffset zoneOffset = zoneId.getRules().getOffset(LocalDateTime.now());
            long timestamp = value.toInstant(zoneOffset).toEpochMilli();
            gen.writeNumber(timestamp);
        }
    }
}
