package com.kit.deliver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @ClassName Task
 * @Description Task used to integrate messages and rules
 * @Author jihainan
 * @Date 2021/10/29 1:44 上午
 * @Version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "task")
public class Task {
    @Id
    private String id;

    /**
     * deliver task name
     */
    private String name;

    /**
     * associate message
     */
    @DBRef(lazy = true)
    private Message message;

    /**
     * associate rules
     */
    @DBRef(lazy = true)
    private List<Rule> rules;
}
