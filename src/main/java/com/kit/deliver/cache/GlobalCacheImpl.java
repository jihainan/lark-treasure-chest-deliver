package com.kit.deliver.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName GlobalCacheImpl
 * @Description the implement of GlobalCache interface
 * @Author jihainan
 * @Date 2021/12/31 1:29 下午
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
@Component
public class GlobalCacheImpl implements GlobalCache{

    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Boolean expire(String key, Long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(Arrays.asList(key));
            }
        }
    }

    @Override
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean set(String key, Object value, Long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Long incr(String key, Long delta) {
        if (delta < 0) {
            throw new RuntimeException("Incremental factor must be greater than 0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public Long decr(String key, Long delta) {
        if (delta < 0) {
            throw new RuntimeException("Decremental factor must be little than 0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    @Override
    public Object hashGet(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    @Override
    public Map<Object, Object> hashMapGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public Boolean hashMapSet(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean hashMapSet(String key, Map<String, Object> map, Long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean hashSet(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean hashSet(String key, String item, Object value, Long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void hashDelete(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    @Override
    public Boolean hasHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    @Override
    public Double hashIncr(String key, String item, Double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    @Override
    public Double hashDecr(String key, String item, Double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    @Override
    public Set<Object> setGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean setHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Long setSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    public Long setSetAndTime(String key, Long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    public Long setGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    public Long setRemove(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    public List<Object> listGet(String key, Long start, Long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Long listGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    public Object listGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean listSet(String key, Object value) {
        try {
            redisTemplate.opsForList().leftPushIfPresent(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean listSet(String key, Object value, Long time) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean listSetAll(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().leftPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean listSetAll(String key, List<Object> value, Long time) {
        try {
            redisTemplate.opsForList().leftPushAll(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean objectSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean objectSet(String key, Object value, Long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean objectSetAll(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean objectSetAll(String key, List<Object> value, Long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean listUpdateIndex(String key, Long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Long listRemove(String key, Long count, Object value) {
        try {
            return redisTemplate.opsForList().remove(key, count, value);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override
    public void rangeRemove(String key, Long start, Long end) {
        try {
            redisTemplate.opsForList().trim(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
