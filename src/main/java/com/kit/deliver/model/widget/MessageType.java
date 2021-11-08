package com.kit.deliver.model.widget;

/**
 * @EnumName MessageType
 * @Description MessageType
 * @Author jihainan
 * @Date 2021/11/8 12:29 上午
 * @Version 1.0
 */
public enum MessageType {

    /**
     * notice with a single video
     */
    VIDEO_NOTICE(1);

    Integer value;

    MessageType (Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
