package com.kit.deliver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName Rule
 * @Description rule info
 * @Author jihainan
 * @Date 2021/10/26 下午2:26
 * @Version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "rule")
public class Rule {
    @Id
    private String id;

    @DBRef
    private Message message;
}