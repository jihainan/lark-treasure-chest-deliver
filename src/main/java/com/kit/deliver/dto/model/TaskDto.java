package com.kit.deliver.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName TaskDto
 * @Description TaskDto used to integrate messages and rules
 * @Author jihainan
 * @Date 2021/10/29 1:31 上午
 * @Version 1.0
 * Additional Statement:
 * 1. @JsonInclude(value = JsonInclude.Include.NON_NULL)
 *    to ignore null fields when serializing the class
 * 2. @JsonIgnoreProperties(ignoreUnknown = true)
 *    to safely ignore unknown properties
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDto {

    /**
     * deliver task name
     */
    private String name;

    /**
     * message type enum by MessageType
     */
    private Integer messageType;

    /**
     * content of task
     */
    private Object messageContent;

    /**
     * message rule
     */
    private List<RuleDto> rules;
}
