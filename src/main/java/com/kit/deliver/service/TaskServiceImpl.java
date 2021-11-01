package com.kit.deliver.service;

import com.kit.deliver.dto.model.TaskDto;
import com.kit.deliver.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @ClassName TaskServiceImpl
 * @Description Task Service implement
 * @Author jihainan
 * @Date 2021/10/29 4:07 下午
 * @Version 1.0
 */
@Component
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
