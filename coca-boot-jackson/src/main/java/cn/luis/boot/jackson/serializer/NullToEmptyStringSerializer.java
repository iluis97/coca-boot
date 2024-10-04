package cn.luis.boot.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class NullToEmptyStringSerializer extends StdSerializer<String> {
    public NullToEmptyStringSerializer() {
        super(String.class);
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeString("");
        } else {
            gen.writeString(value);
        }
    }
}
