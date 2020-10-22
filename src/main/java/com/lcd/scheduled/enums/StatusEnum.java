package com.lcd.scheduled.enums;

public enum StatusEnum {
    DISABLED(0),ENABLED(1);
    private Integer code;
    StatusEnum(int code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
