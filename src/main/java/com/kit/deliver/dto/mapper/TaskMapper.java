package com.kit.deliver.dto.mapper;

import com.kit.deliver.dto.model.TaskDto;
import com.kit.deliver.model.Task;

import java.util.stream.Collectors;

/**
 * @ClassName TaskMapper
 * @Description task model to task
 * @Author jihainan
 * @Date 2021/11/6 4:07 下午
 * @Version 1.0
 */
public class TaskMapper {

    public static TaskDto toTaskDto(Task task) {

        return new TaskDto()
                .setName(task.getName())
                .setMessageType(task.getMessage().getType())
                .setMessageContent(task.getMessage().getContent())
                .setRules(task.getRules().stream().map(RuleMapper::toRuleDto)
                        .collect(Collectors.toList()));
    }

}
