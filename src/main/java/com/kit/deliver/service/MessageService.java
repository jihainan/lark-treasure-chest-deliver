package com.kit.deliver.service;

import com.kit.deliver.dto.model.MessageDto;
import com.kit.deliver.model.Message;

import java.util.List;

/**
 * @InterfaceName MessageService
 * @Description Message service interface
 * @Author jihainan
 * @Date 2021/10/29 4:09 下午
 * @Version 1.0
 */
public interface MessageService {

    /**
     * add message
     * @Author jihainan
     * @Description add message
     * @Date 6:10 下午 2021/11/3
     * @param  messageDto message data transfer object
     * @return com.kit.deliver.dto.model.MessageDto
     */
    Message addMessage(MessageDto messageDto);

    /**
     * get message by message id
     * @Author jihainan
     * @Description get message by message id
     * @Date 10:46 上午 2021/11/4
     * @param messageId message id
     * @return com.kit.deliver.model.Message
     */
    Message getMessageById(String messageId);

    /**
     * get message list by message id list
     * @Author jihainan
     * @Description get message list by message id list
     * @Date 10:01 上午
     * @param messageIds message id list
     * @return java.util.List<com.kit.deliver.dto.model.MessageDto>
     */
    List<MessageDto> getMessageListByIds(List<String> messageIds);

}
