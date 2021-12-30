package com.kit.deliver.service;

import com.kit.deliver.dto.mapper.TaskMapper;
import com.kit.deliver.dto.model.MessageDto;
import com.kit.deliver.dto.model.RuleDto;
import com.kit.deliver.dto.model.TaskDto;
import com.kit.deliver.exception.CustomException;
import com.kit.deliver.exception.widget.EntityType;
import com.kit.deliver.exception.widget.ExceptionType;
import com.kit.deliver.model.Message;
import com.kit.deliver.model.Rule;
import com.kit.deliver.model.Task;
import com.kit.deliver.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kit.deliver.exception.widget.EntityType.*;
import static com.kit.deliver.exception.widget.ExceptionType.*;

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
    private MessageService messageService;
    private RuleService ruleService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    public void setRuleService(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toTaskDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public TaskDto getTaskById(String taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isPresent()) {
            return TaskMapper.toTaskDto(task.get());
        }
        throw exception(TASK, ENTITY_NOT_FOUND, taskId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Task publishTask(TaskDto taskDto) {
        // add a new message
        MessageDto messageDto = new MessageDto()
                .setType(taskDto.getMessageType())
                .setContent(taskDto.getMessageContent());
        Message message = messageService.addMessage(messageDto);

        // add rules corresponding to the message
        List<RuleDto> rulesDto = taskDto.getRules();
        rulesDto.forEach(ruleDto -> ruleDto.setMessageId(message.getId()));
        List<Rule> rules =  ruleService.batchAddRules(rulesDto);

        // after message and rules saved, add new task
        Task taskModel = new Task()
                .setName(taskDto.getName())
                .setMessage(message)
                .setRules(rules);
        taskRepository.save(taskModel);

        return taskModel;
    }

    /**
     * @Author jihainan
     * @Description runtime exception in task service implement
     * @Date 4:23 下午
     * @param entityType entity type
     * @param exceptionType exception type
     * @param args others
     * @return java.lang.RuntimeException
     */
    private RuntimeException exception (EntityType entityType, ExceptionType exceptionType, String... args) {
        return CustomException.throwException(entityType, exceptionType, args);
    }

    /**
     * @Author jihainan
     * @Description runtime exception with id in task service implement
     * @Date 4:23 下午
     * @param entityType entity type
     * @param exceptionType exception type
     * @param id entity id
     * @param args others
     * @return java.lang.RuntimeException
     */
    private RuntimeException exceptionWithId(EntityType entityType, ExceptionType exceptionType, String id, String... args) {
        return CustomException.throwExceptionWithId(entityType, exceptionType, id, args);
    }
}
