package com.kit.deliver.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName Message
 * @Description message info
 * @Author jihainan
 * @Date 2021/10/26 下午2:27
 * @Version 1.0
 * Additional Statement:
 * 1. @Accessors(chain = true)generated setters return this instead of void
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "message")
public class Message {
    @Id
    private String id;

    /**
     * message type
     */
    private Integer type;

    /**
     * message content
     */
    private Object content;


}
