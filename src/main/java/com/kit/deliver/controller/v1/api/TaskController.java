package com.kit.deliver.controller.v1.api;

import com.kit.deliver.dto.model.TaskDto;
import com.kit.deliver.dto.response.Response;
import com.kit.deliver.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MessageController
 * @Description Operations pertaining to publish task in deliver application
 * @Author jihainan
 * @Date 2021/10/29 1:10 上午
 * @Version 1.0
 */
@RestController
@RequestMapping("api/v1/deliver/task")
@Api(value = "operations related to deliver tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    @ApiOperation(value = "get all tasks")
    public Response<List<TaskDto>> list() {
        return Response
                .<List<TaskDto>>ok()
                .setPayload(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get a task by task id")
    public Response<TaskDto> query(@PathVariable("id") String id) {
        return Response
                .<TaskDto>ok()
                .setPayload(taskService.getTaskById(id));
    }

}
