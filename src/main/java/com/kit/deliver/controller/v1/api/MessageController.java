package com.kit.deliver.controller.v1.api;

import com.kit.deliver.controller.v1.request.GetMessageRequest;
import com.kit.deliver.dto.model.MessageDto;
import com.kit.deliver.dto.response.Response;
import com.kit.deliver.model.Message;
import com.kit.deliver.service.MessageService;
import com.kit.deliver.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName MessageController
 * @Description Operations pertaining to get messages based on user characteristics in deliver application
 * @Author jihainan
 * @Date 2021/10/29 10:40 上午
 * @Version 1.0
 */
@RestController
@RequestMapping("api/v1/message")
@Api(value = "deliver-application")
public class MessageController {

    private final MessageService messageService;
    private final RuleService ruleService;

    @Autowired
    public MessageController(MessageService messageService, RuleService ruleService) {
        this.messageService = messageService;
        this.ruleService = ruleService;
    }

    @PostMapping("/query")
    @ApiOperation(value = "query messages using user characteristic")
    public Response<List<MessageDto>> queryMessages(@RequestBody @Valid GetMessageRequest getMessageRequest) {
        return Response
                .ok();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "get a message by message id")
    public Response<Message> query(@PathVariable("id") String id) {
        return Response
                .<Message>ok()
                .setPayload(messageService.getMessageById(id));
    }
    @GetMapping("/")
    @ApiOperation(value = "query messages for end user")
    public Response<List<MessageDto>> queryMessages() {
        return Response.ok();
    }
}
