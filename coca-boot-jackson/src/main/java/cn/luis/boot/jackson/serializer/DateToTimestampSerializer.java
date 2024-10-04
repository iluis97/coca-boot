package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateToTimestampSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            // 获取系统默认时区
            ZoneId zoneId = ZoneId.systemDefault();
            // 将 Date 转换为 ZonedDateTime
            ZonedDateTime zonedDateTime = Instant.ofEpochMilli(value.getTime()).atZone(zoneId);
            // 将 ZonedDateTime 转换为时间戳（本地时区）
            long timestamp = zonedDateTime.toInstant().toEpochMilli();
            gen.writeNumber(timestamp);
        }
    }
}

