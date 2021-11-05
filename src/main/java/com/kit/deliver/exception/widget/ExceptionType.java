package com.kit.deliver.exception.widget;

/**
 * @EnumName ExceptionType
 * @Description ExceptionType
 * @Author jihainan
 * @Date 2021/11/5 2:25 上午
 * @Version 1.0
 */
public enum ExceptionType {
    /**
     * not found entity exception
     */
    ENTITY_NOT_FOUND("not.found"),
    /**
     * entity duplication exception
     */
    DUPLICATE_ENTITY("duplicate"),
    /**
     * other entity exception
     */
    ENTITY_EXCEPTION("exception");

    String value;
    ExceptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
