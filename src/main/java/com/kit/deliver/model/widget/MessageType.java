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
     * notice with a single image
     */
    SINGLE_IMG(1),
    /**
     * notice with a single video
     */
    SINGLE_VIDEO(2),
    /**
     * notice with a title, a video and a description
     */
    SINGLE_CASE(3),
    /**
     * notice with a list of cases displaying in vertical
     */
    CASE_LIST_VERTICAL(4),
    /**
     * notice with a list of cases displaying in horizontal
     */
    CASE_LIS_HORIZONTAL(5),
    /**
     * notice with a title, a version, a description and operation buttons
     */
    VERSION_UPDATE(6),
    /**
     * notice with interoperating information and operation buttons
     */
    COLLECT_INFO(7);

    Integer value;

    MessageType (Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
