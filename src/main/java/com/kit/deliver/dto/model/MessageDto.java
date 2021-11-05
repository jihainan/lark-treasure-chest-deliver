package com.kit.deliver.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @ClassName MessageDto
 * @Description Message data transfer model
 * @Author jihainan
 * @Date 2021/11/3 5:53 下午
 * @Version 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    /**
     * message type
     */
    private Integer type;

    /**
     * content of message
     */
    private Object content;
}
