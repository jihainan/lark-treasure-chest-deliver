package com.kit.deliver.service;

import java.util.List;

/**
 * @InterfaceName CacheService
 * @Description cache service interface
 * @Author jihainan
 * @Date 2021/12/31 5:03 下午
 * @Version 1.0
 */
public interface CacheService {

    /**
     * get valid message by user ID and message IDs
     * @Author jihainan
     * @Description get valid message
     * @Date 5:09 下午
     * @param userId     user ID
     * @param messageIds message id list
     * @return java.lang.String
     */
    String getValidMessage(String userId, List<String> messageIds);
    /**
     * set message id to cache if not exist, create new cache
     * @Author jihainan
     * @Description set message id to cache
     * @Date 11:27 下午
     * @param userId    user ID
     * @param messageId message ID
     * @return java.lang.Boolean is successful
     */
    Boolean setMessageCache(String userId, String messageId);
}
