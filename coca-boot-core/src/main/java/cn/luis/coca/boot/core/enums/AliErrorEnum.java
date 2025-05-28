package cn.luis.coca.boot.core.enums;

import cn.luis.coca.boot.core.enums.code.ResponseIEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回信息枚举类（Alibaba）
 *
 * @author luis
 * @since 1.0
 * created 2021/8/16 9:56
 */
@Getter
@AllArgsConstructor
public enum AliErrorEnum implements ResponseIEnum {
    // 成功
    SUCCESS(ResponseIEnum.ok().getCode(), ResponseIEnum.ok().getDesc()),

    // 用户端错误
    USER_ENDPOINT_ERROR("A0001", "用户端错误"),
    USER_REGISTRATION_ERROR("A0100", "用户注册错误"),
    USER_PRIVACY_AGREEMENT_ERROR("A0101", "用户未同意隐私协议"),
    USER_REGION_RESTRICTION("A0102", "注册国家或地区受限"),
    USER_USERNAME_VALIDATION_FAIL("A0110", "用户名校验失败"),
    USER_USERNAME_EXISTS("A0111", "用户名已存在"),
    USER_USERNAME_SENSITIVE_WORDS("A0112", "用户名包含敏感词"),
    USER_USERNAME_SPECIAL_CHARS("A0113", "用户名包含特殊字符"),
    USER_PASSWORD_VALIDATION_FAIL("A0120", "密码校验失败"),
    USER_PASSWORD_LENGTH_SHORT("A0121", "密码长度不够"),
    USER_PASSWORD_STRENGTH_WEAK("A0122", "密码强度不够"),
    USER_VERIFICATION_CODE_INPUT_ERROR("A0130", "校验码输入错误"),
    USER_SMS_VERIFICATION_CODE("A0131", "短信校验码输入错误"),
    USER_EMAIL_VERIFICATION_CODE("A0132", "邮件校验码输入错误"),
    USER_VOICE_VERIFICATION_CODE("A0133", "语音校验码输入错误"),
    USER_ID_DOCUMENT_ERROR("A0140", "用户证件异常"),
    USER_ID_TYPE_NOT_SELECTED("A0141", "用户证件类型未选择"),
    USER_CHINA_ID_INVALID("A0142", "大陆身份证编号校验非法"),
    USER_PASSPORT_INVALID("A0143", "护照编号校验非法"),
    USER_MILITARY_ID_INVALID("A0144", "军官证编号校验非法"),
    USER_BASIC_INFO_VALIDATION_FAIL("A0150", "用户基本信息校验失败"),
    USER_PHONE_FORMAT_INVALID("A0151", "手机格式校验失败"),
    USER_ADDRESS_FORMAT_INVALID("A0152", "地址格式校验失败"),
    USER_EMAIL_FORMAT_INVALID("A0153", "邮箱格式校验失败"),

    // 用户登录异常
    USER_LOGIN_EXCEPTION("A0200", "用户登录异常"),
    USER_ACCOUNT_NOT_EXIST("A0201", "用户账户不存在"),
    USER_ACCOUNT_FROZEN("A0202", "用户账户被冻结"),
    USER_ACCOUNT_DISABLED("A0203", "用户账户已作废"),
    USER_PASSWORD_ERROR("A0210", "用户密码错误"),
    USER_PASSWORD_ATTEMPTS_EXCEEDED("A0211", "用户输入密码错误次数超限"),
    USER_IDENTITY_VALIDATION_FAIL("A0220", "用户身份校验失败"),
    USER_FINGERPRINT_FAIL("A0221", "用户指纹识别失败"),
    USER_FACE_RECOGNITION_FAIL("A0222", "用户面容识别失败"),
    USER_THIRD_PARTY_AUTH_FAIL("A0223", "用户未获得第三方登录授权"),
    USER_LOGIN_EXPIRED("A0230", "用户登录已过期"),
    USER_LOGIN_VERIFICATION_CODE_ERROR("A0240", "用户验证码错误"),
    USER_VERIFICATION_CODE_ATTEMPTS_EXCEEDED("A0241", "用户验证码尝试次数超限"),

    // 访问权限异常
    ACCESS_PERMISSION_DENIED("A0300", "访问权限异常"),
    ACCESS_UNAUTHORIZED("A0301", "访问未授权"),
    AUTHORIZING("A0302", "正在授权中"),
    AUTHORIZATION_REJECTED("A0303", "用户授权申请被拒绝"),
    ACCESS_BLOCKED_BY_PRIVACY("A0310", "因访问对象隐私设置被拦截"),
    AUTHORIZATION_EXPIRED("A0311", "授权已过期"),
    API_ACCESS_DENIED("A0312", "无权限使用 API"),
    USER_ACCESS_BLOCKED("A0320", "用户访问被拦截"),
    BLACKLISTED_USER("A0321", "黑名单用户"),
    USER_ACCESS_ACCOUNT_FROZEN("A0322", "账号被冻结"),
    INVALID_IP_ADDRESS("A0323", "非法 IP 地址"),
    GATEWAY_ACCESS_RESTRICTED("A0324", "网关访问受限"),
    GEO_BLACKLISTED("A0325", "地域黑名单"),
    SERVICE_OVERDUE("A0330", "服务已欠费"),
    USER_SIGNATURE_ERROR("A0340", "用户签名异常"),
    RSA_SIGNATURE_ERROR("A0341", "RSA 签名错误"),

    // 用户请求参数错误
    USER_INVALID_PARAMETER("A0400", "用户请求参数错误"),
    INVALID_MALICIOUS_LINK("A0401", "包含非法恶意跳转链接"),
    INVALID_USER_INPUT("A0402", "无效的用户输入"),
    REQUIRED_PARAMETER_MISSING("A0410", "请求必填参数为空"),
    ORDER_ID_MISSING("A0411", "用户订单号为空"),
    QUANTITY_MISSING("A0412", "订购数量为空"),
    TIMESTAMP_PARAMETER_MISSING("A0413", "缺少时间戳参数"),
    INVALID_TIMESTAMP("A0414", "非法的时间戳参数"),
    PARAMETER_VALUE_OUT_OF_RANGE("A0420", "请求参数值超出允许的范围"),
    PARAMETER_FORMAT_MISMATCH("A0421", "参数格式不匹配"),
    ADDRESS_OUT_OF_SERVICE_RANGE("A0422", "地址不在服务范围"),
    TIME_OUT_OF_SERVICE_RANGE("A0423", "时间不在服务范围"),
    AMOUNT_EXCEEDED("A0424", "金额超出限制"),
    QUANTITY_EXCEEDED("A0425", "数量超出限制"),
    BATCH_REQUEST_EXCEEDED("A0426", "请求批量处理总个数超出限制"),
    JSON_PARSE_FAILED("A0427", "请求 JSON 解析失败"),
    USER_ILLEGAL_CONTENT("A0430", "用户输入内容非法"),
    CONTAINS_SENSITIVE_WORDS("A0431", "包含违禁敏感词"),
    IMAGE_CONTAINS_ILLEGAL_INFO("A0432", "图片包含违禁信息"),
    FILE_COPYRIGHT_VIOLATION("A0433", "文件侵犯版权"),
    USER_OPERATION_EXCEPTION("A0440", "用户操作异常"),
    USER_PAYMENT_TIMEOUT("A0441", "用户支付超时"),
    ORDER_CONFIRMATION_TIMEOUT("A0442", "确认订单超时"),
    ORDER_CLOSED("A0443", "订单已关闭"),

    // 用户请求服务异常
    USER_SERVICE_EXCEPTION("A0500", "用户请求服务异常"),
    REQUEST_LIMIT_EXCEEDED("A0501", "请求次数超出限制"),
    CONCURRENT_REQUESTS_EXCEEDED("A0502", "请求并发数超出限制"),
    USER_OPERATION_WAIT("A0503", "用户操作请等待"),
    WEBSOCKET_CONNECTION_ERROR("A0504", "WebSocket 连接异常"),
    WEBSOCKET_DISCONNECTED("A0505", "WebSocket 连接断开"),
    USER_REPEAT_REQUEST("A0506", "用户重复请求"),

    // 用户资源异常
    USER_RESOURCE_EXCEPTION("A0600", "用户资源异常"),
    INSUFFICIENT_BALANCE("A0601", "账户余额不足"),
    DISK_SPACE_INSUFFICIENT("A0602", "用户磁盘空间不足"),
    MEMORY_INSUFFICIENT("A0603", "用户内存空间不足"),
    OSS_STORAGE_INSUFFICIENT("A0604", "用户 OSS 容量不足"),
    QUOTA_EXHAUSTED("A0605", "用户配额已用光"),

    // 用户上传文件异常
    FILE_UPLOAD_ERROR("A0700", "用户上传文件异常"),
    FILE_TYPE_MISMATCH("A0701", "用户上传文件类型不匹配"),
    FILE_SIZE_EXCEEDED("A0702", "用户上传文件太大"),
    IMAGE_SIZE_EXCEEDED("A0703", "用户上传图片太大"),
    VIDEO_SIZE_EXCEEDED("A0704", "用户上传视频太大"),
    COMPRESSED_FILE_SIZE_EXCEEDED("A0705", "用户上传压缩文件太大"),

    // 用户设备异常
    DEVICE_VERSION_ABNORMAL("A0800", "用户当前版本异常"),
    VERSION_INCOMPATIBLE("A0801", "用户安装版本与系统不匹配"),
    VERSION_TOO_LOW("A0802", "用户安装版本过低"),
    VERSION_TOO_HIGH("A0803", "用户安装版本过高"),
    VERSION_EXPIRED("A0804", "用户安装版本已过期"),
    API_VERSION_MISMATCH("A0805", "用户 API 请求版本不匹配"),
    API_VERSION_TOO_HIGH("A0806", "用户 API 请求版本过高"),
    API_VERSION_TOO_LOW("A0807", "用户 API 请求版本过低"),

    // 用户隐私授权异常
    USER_PRIVACY_UNAUTHORIZED("A0900", "用户隐私未授权"),
    USER_PRIVACY_UNSIGNED("A0901", "用户隐私未签署"),
    CAMERA_UNAUTHORIZED("A0902", "用户摄像头未授权"),
    MICROPHONE_UNAUTHORIZED("A0903", "用户麦克风未授权"),
    GALLERY_UNAUTHORIZED("A0904", "用户图片库未授权"),
    FILE_UNAUTHORIZED("A0905", "用户文件未授权"),
    LOCATION_UNAUTHORIZED("A0906", "用户位置信息未授权"),
    CONTACTS_UNAUTHORIZED("A0907", "用户通讯录未授权"),

    // 设备异常
    DEVICE_CAMERA_ERROR("A1000", "用户相机异常"),
    DEVICE_MICROPHONE_ERROR("A1001", "用户麦克风异常"),
    DEVICE_RECEIVER_ERROR("A1002", "用户听筒异常"),
    DEVICE_SPEAKER_ERROR("A1003", "用户扬声器异常"),
    GPS_LOCATION_ERROR("A1004", "用户 GPS 定位异常");

    /**
     * 错误码：
     * 1. 五位组成
     * 2. A代表用户端错误
     * 3. B代表当前系统异常
     * 4. C代表第三方服务异常
     * 4. 若无法确定具体错误，选择宏观错误
     * 6. 大的错误类间的步长间距预留100
     */
    private final String code;

    /**
     * 错误信息
     */
    private final String desc;
}