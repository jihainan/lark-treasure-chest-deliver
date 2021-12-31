package com.kit.deliver.dto.mapper;

import com.kit.deliver.dto.model.RuleDto;
import com.kit.deliver.model.Rule;

/**
 * @ClassName RuleMapper
 * @Description rule mapper to rule dto
 * @Author jihainan
 * @Date 2021/11/4 12:04 上午
 * @Version 1.0
 */
public class RuleMapper {
    public static RuleDto toRuleDto(Rule rule) {
        return new RuleDto()
                .setMessageId(rule.getMessageId())
                .setPropertyName(rule.getPropertyName());
    }
}
