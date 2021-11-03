package com.kit.deliver.dto.response.widget;


/**
 * @EnumName Response
 * @Description Response status enum
 * @Author jihainan
 * @Date 2021/11/1 4:16 下午
 * @Version 1.0
 */
public enum Status {
    /**
     * response with success
     */
    OK,
    /**
     * response with bad request
     */
    BAD_REQUEST,
    /**
     * response without authorized
     */
    UNAUTHORIZED,
    /**
     * response with validation failed
     */
    VALIDATION_EXCEPTION,
    /**
     * response with common exception
     */
    EXCEPTION,
    /**
     * response with wrong credentials
     */
    WRONG_CREDENTIALS,
    /**
     * response with access denied
     */
    ACCESS_DENIED,
    /**
     * response with not found
     */
    NOT_FOUND,
    /**
     * response with duplicate entity
     */
    DUPLICATE_ENTITY
}
