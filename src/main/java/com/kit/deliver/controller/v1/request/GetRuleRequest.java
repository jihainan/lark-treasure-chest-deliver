package com.kit.deliver.controller.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName GetMessageRequest
 * @Description get rule request model
 * @Author jihainan
 * @Date 2021/11/9 12:23 上午
 * @Version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRuleRequest {

    /**
     * user identifier of any system or application
     */
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String userId;
    /**
     * rule validity period
     */
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String validUntil;

}
