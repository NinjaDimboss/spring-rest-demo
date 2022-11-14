package az.spring.rest.demo.springrestdemo.enums;

public enum ErrorCodeEnum {
    REGISTER_NOT_FOUND(1001, "Qeyd olunan ID ilə istifadəçi tapılmadı"),
    VALIDATION_ERROR(1002, "Yalnız rəqəmlərdən istifadə olunmalıdır!"),
    UNKNOWN_ERROR(1000, "Bilinməyən xəta!");


    private final String message;
    private final int code;

    ErrorCodeEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
