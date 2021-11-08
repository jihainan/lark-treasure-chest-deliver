package com.kit.deliver.service;

import com.kit.deliver.dto.model.RuleDto;
import com.kit.deliver.model.Rule;

import java.util.List;

/**
 * @InterfaceName RuleService
 * @Description Rule service interface
 * @Author jihainan
 * @Date 2021/10/29 4:13 下午
 * @Version 1.0
 */
public interface RuleService {

    /**
     * add rule
     * @Author jihainan
     * @Description rule service
     * @Date 7:20 下午 2021/11/3
     * @param ruleDto rule data transfer object
     * @return com.kit.deliver.dto.model.RuleDto
     */
    Rule addRule(RuleDto ruleDto);


    /**
     * batch set rules of the message
     * @Author jihainan
     * @Description batch set rules of the message
     * @Date 2:04 下午
     * @param rules rule list
     * @return java.util.List<com.kit.deliver.model.Rule>
     */
    List<Rule> batchAddRules(List<RuleDto> rules);
}
