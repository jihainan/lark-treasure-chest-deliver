package com.kit.deliver.repository;

import com.kit.deliver.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @InterfaceName MessageRepository
 * @Description message repository interface
 * @Author jihainan
 * @Date 2021/10/26 下午5:56
 * @Version 1.0
 */
public interface MessageRepository extends MongoRepository<Message, String> {
}
