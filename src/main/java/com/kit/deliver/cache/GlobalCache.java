package com.kit.deliver.cache;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @InterfaceName GlobalCache
 * @Description global redis cache interface
 * @Author jihainan
 * @Date 2021/12/31 10:37 上午
 * @Version 1.0
 */
public interface GlobalCache {
    /**
     * set expire time
     * @Author jihainan
     * @Description set expire time
     * @Date 10:55 上午
     * @param key  cache key
     * @param time expire time
     * @return java.lang.Boolean
     */
    Boolean expire(String key, Long time);
    /**
     * get expire time
     * @Author jihainan
     * @Description get expire time
     * @Date 10:56 上午
     * @param key cache not null
     * @return java.lang.Long expire time(s) 0: permanently valid
     */
    Long getExpire(String key);
    /**
     * key exist or not
     * @Author jihainan
     * @Description key exist or not
     * @Date 10:57 上午
     * @param key cache key
     * @return java.lang.Boolean is exit or not
     */
    Boolean hasKey(String key);
    /**
     * delete cache
     * @Author jihainan
     * @Description delete cache
     * @Date 10:57 上午
     * @param key cache keys
     * @return void
     */
    void del(String... key);
    // ============================String=============================
    /**
     * get cache by cache key
     * @Author jihainan
     * @Description get cache by cache key
     * @Date 10:57 上午
     * @param key cache key
     * @return java.lang.Object cache value
     */
    Object get(String key);
    /**
     * set cache
     * @Author jihainan
     * @Description set cache
     * @Date 10:58 上午
     * @param key   cache key
     * @param value cache value
     * @return java.lang.Boolean is successful
     */
    Boolean set(String key, Object value);
    /**
     * set cache and set expire time
     * @Author jihainan
     * @Description set cache and set expire time
     * @Date 10:59 上午
     * @param key    cache key
     * @param value  value
     * @param time   expire time(s > 0; < 0 respect permanent)
     * @return java.lang.Boolean is successful
     */
    Boolean set(String key, Object value, Long time);
    /**
     * increase cache value
     * @Author jihainan
     * @Description increase cache value
     * @Date 10:59 上午
     * @param key   cache key
     * @param delta increase value(> 0)
     * @return java.lang.Long new value
     */
    Long incr(String key, Long delta);
    /**
     * decrease value
     * @Author jihainan
     * @Description decrease value
     * @Date 11:00 上午
     * @param key   key
     * @param delta increase value(< 0)
     * @return java.lang.Long
     */
    Long decr(String key, Long delta);
    /**
     * get hash
     * @Author jihainan
     * @Description get hash
     * @Date 11:00 上午
     * @param key   key not null
     * @param item  value not null
     * @return java.lang.Object value
     */
    Object hashGet(String key, String item);
    /**
     * get key and value of hash key
     * @Author jihainan
     * @Description get key and value of hash key
     * @Date 10:54 上午
     * @param key key
     * @return java.util.Map<java.lang.Object,java.lang.Object> value map
     */
    Map<Object, Object> hashMapGet(String key);
    /**
     * set hash map
     * @Author jihainan
     * @Description set hash map
     * @Date 11:02 上午
     * @param key key
     * @param map key and value
     * @return java.lang.Boolean is successful
     */
    Boolean hashMapSet(String key, Map<String, Object> map);
    /**
     * set hash map and expire time
     * @Author jihainan
     * @Description set hash map and expire time
     * @Date 11:03 上午
     * @param key  key
     * @param map  map with key and value
     * @param time expire time
     * @return java.lang.Boolean is successful
     */
    Boolean hashMapSet(String key, Map<String, Object> map, Long time);
    /**
     * set hash
     * @Author jihainan
     * @Description set hash
     * @Date 11:06 上午
     * @param key   key
     * @param item  item
     * @param value value
     * @return java.lang.Boolean
     */
    Boolean hashSet(String key, String item, Object value);
    /**
     * set hash with expire time
     * @Author jihainan
     * @Description set hash with expire time
     * @Date 11:07 上午
     * @param key   key
     * @param item  item
     * @param value value
     * @param time  expire time
     * @return boolean
     */
    Boolean hashSet(String key, String item, Object value, Long time);
    /**
     * delete hash item
     * @Author jihainan
     * @Description delete hash item
     * @Date 11:11 上午
     * @param key  key
     * @param item item
     * @return void
     */
    void hashDelete(String key, Object... item);
    /**
     * is present in hash
     * @Author jihainan
     * @Description is present in hash
     * @Date 11:12 上午
     * @param key  key not null
     * @param item item not null
     * @return java.lang.Boolean is present
     */
    Boolean hasHasKey(String key, String item);
    /**
     * hash increment
     * @Author jihainan
     * @Description hash increment if it doesn't exist, it creates one and returns the new value.
     * @Date 11:14 上午
     * @param key  key
     * @param item item
     * @param by   increase value
     * @return java.lang.Double new value
     */
    Double hashIncr(String key, String item, Double by);
    /**
     * hash decrement
     * @Author jihainan
     * @Description hash decrement
     * @Date 11:14 上午
     * @param key  key
     * @param item item
     * @param by   increase value (<0)
     * @return java.lang.Double new value
     */
    Double hashDecr(String key, String item, Double by);
    /**
     * get value by key
     * @Author jihainan
     * @Description get value by key
     * @Date 11:19 上午
     * @param key key
     * @return java.util.Set<java.lang.Object> value
     */
    Set<Object> setGet(String key);
    /**
     * query from a set based on value, whether it exists or not
     * @Author jihainan
     * @Description query from a set based on value, whether it exists or not
     * @Date 11:21 上午
     * @param key   key
     * @param value value
     * @return java.lang.Boolean set has key
     */
    Boolean setHasKey(String key, Object value);
    /**
     * set date to set
     * @Author jihainan
     * @Description set date to set
     * @Date 12:58 下午
     * @param key key
     * @param values value
     * @return java.lang.Long number of successes
     */
    Long setSet(String key, Object... values);
    /**
     * set date to set and expire time
     * @Author jihainan
     * @Description set date to set and expire time
     * @Date 12:59 下午
     * @param key    key
     * @param time   expire time
     * @param values values
     * @return java.lang.Long
     */
    Long setSetAndTime(String key, Long time, Object... values);
    /**
     * get the length of set
     * @Author jihainan
     * @Description get the length of set
     * @Date 1:01 下午
     * @param key key
     * @return java.lang.Long set size
     */
    Long setGetSetSize(String key);
    /**
     * remove value in set
     * @Author jihainan
     * @Description remove value in set
     * @Date 1:05 下午
     * @param key    key
     * @param values values
     * @return java.lang.Long number of removed
     */
    Long setRemove(String key, Object... values);
    /**
     * get value of list cache
     * @Author jihainan
     * @Description get value of list cache
     * @Date 1:07 下午
     * @param key   key
     * @param start start position
     * @param end   end position 0 to -1 for all values
     * @return java.util.List<java.lang.Object>
     */
    List<Object> listGet(String key, Long start, Long end);
    /**
     * get list cache length
     * @Author jihainan
     * @Description get list cache length
     * @Date 1:09 下午  
     * @param key key
     * @return java.lang.Long length
     */
    Long listGetListSize(String key);
    /**
     * get value by index
     * @Author jihainan
     * @Description get value by index
     * @Date 1:09 下午  
     * @param key   key
     * @param index key
     *              index>=0, 0 table head, 1 second element, and so on;
     *              index<0, -1 table tail, -2 penultimate element, and so on
     * @return java.lang.Object
     */
    Object listGetIndex(String key, long index);
    /**
     * set list to cache
     * @Author jihainan
     * @Description set list to cache
     * @Date 1:12 下午
     * @param key   key
     * @param value value
     * @return java.lang.Boolean is successful
     */
    Boolean listSet(String key, Object value);

    /**
     * set list to cache and expire time
     * @Author jihainan
     * @Description set list to cache
     * @Date 1:12 下午
     * @param key   key
     * @param value value
     * @param time  expire time
     * @return java.lang.Boolean is successful
     */
    Boolean listSet(String key, Object value, Long time);
    /**
     * set list to cache
     * @Author jihainan
     * @Description set list to cache
     * @Date 1:15 下午
     * @param key   key
     * @param value value
     * @return java.lang.Boolean is successful
     */
    Boolean listSetAll(String key, List<Object> value);
    /**
     * set list to cache with expire time
     * @Author jihainan
     * @Description set list to cache with expire time
     * @Date 1:16 下午  
     * @param key   key
     * @param value value
     * @param time  expire time
     * @return java.lang.Boolean is successful
     */
    Boolean listSetAll(String key, List<Object> value, Long time);
    /**
     * put value in cache
     * @Author jihainan
     * @Description put value in cache
     * @Date 1:25 下午
     * @param key   key
     * @param value value
     * @return java.lang.Boolean is successful
     */
    Boolean objectSet(String key, Object value);
    /**
     * put value in cache
     * @Author jihainan
     * @Description put value in cache
     * @Date 1:25 下午
     * @param key   key
     * @param value value
     * @param time  expire time
     * @return java.lang.Boolean is successful
     */
    Boolean objectSet(String key, Object value, Long time);
    /**
     * put value in cache
     * @Author jihainan
     * @Description put value in cache
     * @Date 1:25 下午
     * @param key   key
     * @param value value
     * @return java.lang.Boolean is successful
     */
    Boolean objectSetAll(String key, List<Object> value);
    /**
     * put value in cache
     * @Author jihainan
     * @Description put value in cache
     * @Date 1:25 下午
     * @param key   key
     * @param value value
     * @param time  expire time
     * @return java.lang.Boolean is successful
     */
    Boolean objectSetAll(String key, List<Object> value, Long time);
    /**
     * modify a data item in a list according to its index
     * @Author jihainan
     * @Description modify list value
     * @Date 1:24 下午  
     * @param key   key
     * @param index index
     * @param value new value
     * @return java.lang.Boolean
     */
    Boolean listUpdateIndex(String key, Long index, Object value);
    /**
     * remove N item of the value
     * @Author jihainan
     * @Description remove N item of the value
     * @Date 1:22 下午  
     * @param key   key
     * @param count number to remove
     * @param value value to remove
     * @return java.lang.Long number of removed
     */
    Long listRemove(String key, Long count, Object value);
    /**
     * remove item between start and end
     * @Author jihainan
     * @Description remove item between start and end
     * @Date 11:09 上午
     * @param key   key
     * @param start start position
     * @param end   end position
     * @return void
     */
    void rangeRemove(String key, Long start, Long end);
    /**
     * return current redis template
     * @Author jihainan
     * @Description return current redis template
     * @Date 11:08 上午
     * @return org.springframework.data.redis.core.RedisTemplate
     */
    RedisTemplate<String, Object> getRedisTemplate();
}
