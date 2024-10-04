package cn.luis.coca.boot.util;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * gzip&base64 encode and decode
 *
 * @author luis
 */
public class GzipBase64Utils {

    public static String encode(String context) {
        try (ByteArrayOutputStream rstBao = new ByteArrayOutputStream();
             GZIPOutputStream zos = new GZIPOutputStream(rstBao)) {
            zos.write(context.getBytes(StandardCharsets.UTF_8));
            zos.close();
            byte[] encode = Base64.getEncoder().encode(rstBao.toByteArray());
            return new String(encode, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("GzipBase64Utils encode error", e);
        }
    }

    public static String decode(String encodeContext) {
        try {
            byte[] decode = Base64.getDecoder().decode(encodeContext.getBytes());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
            return IOUtils.toString(new GZIPInputStream(byteArrayInputStream), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("GzipBase64Utils decode error", e);
        } finally {
            IOUtils.closeQuietly();
        }
    }

}
