package com.kit.deliver.controller.v1.api;

import com.kit.deliver.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MessageController
 * @Description Operations pertaining to publish task in deliver application
 * @Author jihainan
 * @Date 2021/10/29 1:10 上午
 * @Version 1.0
 */
@RestController
@RequestMapping("api/v1/deliver/")
@Api(value = "deliver-application")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("tasks")
    @ApiOperation(value = "")
    public Object getAllTasks() {
        return taskService.getAllTasks();
    }
}
