package com.kit.deliver.service;

import com.kit.deliver.dto.model.RuleDto;
import com.kit.deliver.model.Message;
import com.kit.deliver.model.Rule;
import com.kit.deliver.repository.RuleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public RuleDto addRule(RuleDto ruleDto) {
        Message message = messageService.getMessageById(ruleDto.getMessageId());
        Rule ruleModel = new Rule()
                .setPropertyName(ruleDto.getPropertyName())
                .setMessage(message);
        ruleRepository.save(ruleModel);
        return modelMapper.map(ruleModel, RuleDto.class);
    }
}
