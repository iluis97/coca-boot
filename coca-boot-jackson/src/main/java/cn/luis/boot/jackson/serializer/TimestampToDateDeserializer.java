package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class TimestampToDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        long timestamp = p.getLongValue();
        // 获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        // 将时间戳转换为 ZonedDateTime
        ZonedDateTime zonedDateTime = Instant.ofEpochMilli(timestamp).atZone(zoneId);
        // 获取调整后的时间戳
        long adjustedTimestamp = zonedDateTime.toInstant().toEpochMilli();
        // 返回 Date 对象
        return new Date(adjustedTimestamp);
    }
}

