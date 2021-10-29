package com.kit.deliver.repository;

import com.kit.deliver.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @InterfaceName TaskRepository
 * @Description Deliver task repository
 * @Author jihainan
 * @Date 2021/10/29 3:45 下午
 * @Version 1.0
 */
public interface TaskRepository extends MongoRepository<Task, String> {
}
