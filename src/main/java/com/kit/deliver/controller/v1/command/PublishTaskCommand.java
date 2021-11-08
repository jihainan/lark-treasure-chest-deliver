package com.kit.deliver.controller.v1.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kit.deliver.dto.model.RuleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ClassName PublishTaskCommand
 * @Description command for publishing a new task
 * @Author jihainan
 * @Date 2021/11/8 9:52 上午
 * @Version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublishTaskCommand {
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String name;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private Integer messageType;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private Object messageContent;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private List<RuleDto> rulesList;
}
