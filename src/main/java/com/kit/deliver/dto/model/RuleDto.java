package com.kit.deliver.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName RuleDto
 * @Description Data transfer model of rule
 * @Author jihainan
 * @Date 2021/11/3 6:06 下午
 * @Version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuleDto {

    /**
     * property name related to rule
     */
    private String propertyName;
    /**
     * rule validity period
     */
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String validUntil;

    /**
     * related message id
     */
    private String messageId;
}
