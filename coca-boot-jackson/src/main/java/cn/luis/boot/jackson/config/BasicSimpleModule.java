package cn.luis.boot.jackson.config;

import cn.luis.boot.jackson.serializer.DateToTimestampSerializer;
import cn.luis.boot.jackson.serializer.LocalDateTimeToTimestampSerializer;
import cn.luis.boot.jackson.serializer.NullToEmptyStringDeserializer;
import cn.luis.boot.jackson.serializer.NullToEmptyStringSerializer;
import cn.luis.boot.jackson.serializer.StringToLongDeserializer;
import cn.luis.boot.jackson.serializer.TimestampToDateDeserializer;
import cn.luis.boot.jackson.serializer.TimestampToLocalDateTimeDeserializer;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDateTime;
import java.util.Date;

public class BasicSimpleModule extends SimpleModule {

    public BasicSimpleModule() {
        super("BasicSimpleModule", Version.unknownVersion());

        // 配置全局的 Long、long 类型序列化和反序列化
        addSerializer(Long.class, new ToStringSerializer());
        addDeserializer(Long.class, new StringToLongDeserializer());
        addSerializer(Long.TYPE, new ToStringSerializer());
        addDeserializer(Long.TYPE, new StringToLongDeserializer());

        // 配置全局的 LocalDateTime 类型序列化和反序列化
        addSerializer(LocalDateTime.class, new LocalDateTimeToTimestampSerializer());
        addDeserializer(LocalDateTime.class, new TimestampToLocalDateTimeDeserializer());

        // 配置全局的 Date 类型序列化和反序列化
        addSerializer(Date.class, new DateToTimestampSerializer());
        addDeserializer(Date.class, new TimestampToDateDeserializer());

        // 配置全局的 String 类型序列化和反序列化
        addSerializer(String.class, new NullToEmptyStringSerializer());
        addDeserializer(String.class, new NullToEmptyStringDeserializer());
    }

}
