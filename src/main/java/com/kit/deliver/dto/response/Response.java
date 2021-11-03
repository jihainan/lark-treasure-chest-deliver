package com.kit.deliver.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kit.deliver.dto.response.widget.ResponseError;
import com.kit.deliver.dto.response.widget.Status;
import com.kit.deliver.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @ClassName Response
 * @Description Base response entity
 * @Author jihainan
 * @Date 2021/11/1 4:16 下午
 * @Version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private Status status;
    private T payload;
    private Object errors;
    private Object metadata;

    /**
     * @Author jihainan
     * @Description Generate bad response
     * @Date 12:32 上午 2021/11/2
     * @return com.kit.deliver.dto.response.Response<T>
     * Additional Statement:
     * <T> shows that this is a generic method
     *     the number can be more than one <T, K>
     */
    public static <T> Response<T> badRequest() {
        Response<T> response = new Response<>();
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    /**
     * @Author jihainan
     * @Description Generate ok response
     * @Date 12:46 上午 2021/11/2
     * @return com.kit.deliver.dto.response.Response<T>
     */
    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(Status.OK);
        return response;
    }

    /**
     * @Author jihainan
     * @Description Generate response with exception
     * @Date 12:47 上午 2021/11/2
     * @return com.kit.deliver.dto.response.Response<T>
     */
    public static <T> Response<T> exception() {
        Response<T> response = new Response<>();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

    /**
     * @Author jihainan
     * @Description Generate response with not found
     * @Date 12:49 上午 2021/11/2
     * @return com.kit.deliver.dto.response.Response<T>
     */
    public static <T> Response<T> notFound() {
        Response<T> response = new Response<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

    /**
     * @Author jihainan
     * @Description generate response with duplicate
     * @Date 12:51 上午 2021/11/2
     * @return com.kit.deliver.dto.response.Response<T>
     */
    public static <T> Response<T> duplicateEntity() {
        Response<T> response = new Response<>();
        response.setStatus(Status.DUPLICATE_ENTITY);
        return response;
    }

    /**
     * @Author jihainan
     * @Description Add error message to response
     * @Date 1:00 上午 2021/11/2
     * @Param [errorMsg, ex]
     * @return void
     */
    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
        ResponseError error = new ResponseError()
                .setDetails(errorMsg)
                .setMessage(ex.getMessage())
                .setTimestamp(DateUtils.today());
        setErrors(error);
    }


}
