package com.kit.deliver.service;

import com.kit.deliver.controller.v1.request.GetRuleRequest;
import com.kit.deliver.dto.model.RuleDto;
import com.kit.deliver.exception.CustomException;
import com.kit.deliver.exception.widget.EntityType;
import com.kit.deliver.exception.widget.ExceptionType;
import com.kit.deliver.model.Message;
import com.kit.deliver.model.Rule;
import com.kit.deliver.repository.RuleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RuleServiceImpl
 * @Description Rule service implement
 * @Author jihainan
 * @Date 2021/10/29 4:13 下午
 * @Version 1.0
 */
@Component
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;
    private final ModelMapper modelMapper;
    private MessageService messageService;

    @Autowired
    public RuleServiceImpl(RuleRepository ruleRepository, ModelMapper modelMapper) {
        this.ruleRepository = ruleRepository;
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Rule addRule(RuleDto ruleDto) {
        Message message = messageService.getMessageById(ruleDto.getMessageId());
        Rule ruleModel = new Rule()
                .setPropertyName(ruleDto.getPropertyName())
                .setValidUntil(ruleDto.getValidUntil())
                .setMessageId(message.getId());
        return ruleRepository.save(ruleModel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Rule> batchAddRules(List<RuleDto> rules) {
        List<Rule> results = new ArrayList<>();
        rules.forEach(ruleDto -> results.add(addRule(ruleDto)));
        return results;
    }

    @Override
    public List<Rule> queryMatchingRules(GetRuleRequest getRuleRequest) {
        return ruleRepository.findRulesByValidUntilAfter(getRuleRequest.getValidUntil());
    }

    /**
     * @Author jihainan
     * @Description  rule exception
     * @Date 11:07 上午
     * @param entityType rule entity
     * @param exceptionType exception type
     * @param args others
     * @return java.lang.RuntimeException
     */
    private RuntimeException ruleException(EntityType entityType, ExceptionType exceptionType, String... args) {
        return CustomException.throwException(entityType, exceptionType, args);
    }

    /**
     * @Author jihainan
     * @Description rule exception with id
     * @Date 11:11 上午
     * @param entityType rule entity
     * @param exceptionType exception type
     * @param id rule id
     * @param args others
     * @return java.lang.RuntimeException
     */
    private RuntimeException ruleExceptionWithId(EntityType entityType, ExceptionType exceptionType, String id, String... args) {
        return CustomException.throwExceptionWithId(entityType, exceptionType, id, args);
    }

}
