package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimestampToLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        long timestamp = p.getLongValue();
        // 获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        // 将时间戳转换为 LocalDateTime，使用本地时区
        return LocalDateTime.ofEpochSecond(timestamp / 1000, 0, zoneId.getRules().getOffset(LocalDateTime.now()));
    }
}
