package cn.luis.coca.boot.core.enums.time;

import cn.luis.coca.boot.core.base.YmdHms;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@SuppressWarnings("all")
public enum YmdHmsEnum {

    yyyy_MM_ddHHmmss(YmdHms.yyyy_MM_ddHHmmss, YmdHms.formatter_yyyy_MM_ddHHmmss),
    yyyyMMddHHmmssSSS(YmdHms.yyyyMMddHHmmssSSS, YmdHms.formatter_yyyyMMddHHmmssSSS),
    yyyyMMddHHmmss(YmdHms.yyyyMMddHHmmss, YmdHms.formatter_yyyyMMddHHmmss),
    yyyyMMddTHHmmssZ(YmdHms.yyyyMMddTHHmmssZ, YmdHms.formatter_yyyyMMddTHHmmssZ),
    yyyyMMddTHHmmss(YmdHms.yyyyMMddTHHmmss, YmdHms.formatter_yyyyMMddTHHmmss);

    private final String content;
    private final DateTimeFormatter formatter;
}