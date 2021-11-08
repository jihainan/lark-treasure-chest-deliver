package com.kit.deliver.service;

import com.kit.deliver.dto.model.MessageDto;
import com.kit.deliver.exception.CustomException;
import com.kit.deliver.exception.widget.EntityType;
import com.kit.deliver.exception.widget.ExceptionType;
import com.kit.deliver.model.Message;
import com.kit.deliver.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.kit.deliver.exception.widget.EntityType.*;

/**
 * @ClassName MessageServiceImpl
 * @Description Message service implement
 * @Author jihainan
 * @Date 2021/10/29 4:09 下午
 * @Version 1.0
 */
@Component
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MessageServiceImpl (MessageRepository messageRepository, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Message addMessage(MessageDto messageDto) {
        Message messageModel = new Message()
                .setType(messageDto.getType())
                .setContent(messageDto.getContent());
        return messageRepository.save(messageModel);
    }

    @Override
    public Message getMessageById(String messageId) {
        Optional<Message> message = messageRepository.findById(messageId);
        if (message.isPresent()) {
            return message.get();
        }
        throw messageExceptionWithId(MESSAGE, ExceptionType.ENTITY_NOT_FOUND, messageId);
    }

    /**
     * @Author jihainan
     * @Description  message exception
     * @Date 11:07 上午
     * @param entityType message entity
     * @param exceptionType exception type
     * @param args others
     * @return java.lang.RuntimeException
     */
    private RuntimeException messageException(EntityType entityType, ExceptionType exceptionType, String... args) {
        return CustomException.throwException(entityType, exceptionType, args);
    }

    /**
     * @Author jihainan
     * @Description message exception with id
     * @Date 11:11 上午
     * @param entityType message entity
     * @param exceptionType exception type
     * @param id message id
     * @param args others
     * @return java.lang.RuntimeException
     */
    private RuntimeException messageExceptionWithId(EntityType entityType, ExceptionType exceptionType, String id, String... args) {
        return CustomException.throwExceptionWithId(entityType, exceptionType, id, args);
    }

}
