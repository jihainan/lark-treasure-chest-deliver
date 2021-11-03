package com.kit.deliver.dto.response.widget;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ClassName ResponseError
 * @Description Response error object
 * @Author jihainan
 * @Date 2021/11/2 12:54 上午
 * @Version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseError {
    /**
     * timestamp of error
     */
    private Date timestamp;
    /**
     * error message
     */
    private String message;
    /**
     * error detail
     */
    private String details;
}
