package com.kit.deliver.repository;

import com.kit.deliver.model.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @InterfaceName RuleRepository
 * @Description rule repository interface
 * @Author jihainan
 * @Date 2021/10/26 下午5:57
 * @Version 1.0
 */
public interface RuleRepository extends MongoRepository<Rule, String> {
    /**
     * find rules by valid until
     * @Author jihainan
     * @Description find rules by valid until
     * @Date 2:12 上午
     * @param validUntil rule validity period
     * @return java.util.List<com.kit.deliver.model.Rule>
     */
    List<Rule> findRulesByValidUntilAfter(String validUntil);
}
