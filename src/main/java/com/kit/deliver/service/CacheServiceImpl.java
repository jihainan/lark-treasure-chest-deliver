package com.kit.deliver.service;

import com.kit.deliver.cache.GlobalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CacheServiceImpl
 * @Description cache service implement
 * @Author jihainan
 * @Date 2021/12/31 5:11 下午
 * @Version 1.0
 */
@Component
public class CacheServiceImpl implements CacheService{

    private final GlobalCache globalCache;

    @Autowired
    public CacheServiceImpl(GlobalCache globalCache) {
        this.globalCache = globalCache;
    }

    @Override
    public String getValidMessage(String userId, List<String> messageIds) {
        // get cache by user ID
        List<Object> cacheSet = globalCache.listGet(userId, 0L, -1L);
        messageIds.removeAll(cacheSet);

        return messageIds.size() > 0 ? messageIds.get(0) : null;
    }

    @Override
    public Boolean setMessageCache(String userId, String messageId) {
        List<Object> cacheList = globalCache.listGet(userId, 0L, -1L);
        if (cacheList.size() == 0) {
            cacheList.add(messageId);
            return globalCache.listSetAll(userId, cacheList);
        } else {
            return globalCache.listSet(userId, messageId);
        }
    }
}
