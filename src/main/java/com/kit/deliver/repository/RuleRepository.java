package com.kit.deliver.repository;

import com.kit.deliver.model.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @InterfaceName RuleRepository
 * @Description rule repository interface
 * @Author jihainan
 * @Date 2021/10/26 下午5:57
 * @Version 1.0
 */
public interface RuleRepository extends MongoRepository<Rule, String> {
}
