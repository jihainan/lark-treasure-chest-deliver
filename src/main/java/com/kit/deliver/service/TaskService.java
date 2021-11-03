package com.kit.deliver.service;

import com.kit.deliver.dto.model.TaskDto;

import java.util.List;

/**
 * @InterfaceName TaskService
 * @Description Task service interface
 * @Author jihainan
 * @Date 2021/10/29 4:06 下午
 * @Version 1.0
 */
public interface TaskService {

    /**
     * get all tasks
     * @Author jihainan
     * @Description Get all tasks
     * @Date 4:20 下午 2021/10/29
     * @return java.util.Set<com.kit.deliver.dto.model.TaskDto>
     */
    List<TaskDto> getAllTasks();
}
