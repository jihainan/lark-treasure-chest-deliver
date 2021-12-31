package com.kit.deliver.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @ClassName RedisConfiguration
 * @Description redis config class
 * @Author jihainan
 * @Date 2021/12/30 4:56 下午
 * @Version 1.0
 */
@EnableCaching
@Configuration
public class RedisConfiguration {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String pwd;
    @Value("${spring.redis.timeout}")
    private Long timeout;
    @Value("${spring.redis.lettuce.shutdown-timeout}")
    private Long shutDownTime;
    @Value("${spring.redis.lettuce.pool.max-idle}")
    private Integer maxIdle;
    @Value("${spring.redis.lettuce.pool.min-idle}")
    private Integer minIdle;
    @Value("${spring.redis.lettuce.pool.max-active}")
    private Integer maxActive;
    @Value("${spring.redis.lettuce.pool.max-wait}")
    private Long maxWait;

    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        GenericObjectPoolConfig<Object> genericObjectPoolConfig = new GenericObjectPoolConfig<>();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxTotal(maxActive);
        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
        genericObjectPoolConfig.setTimeBetweenEvictionRunsMillis(100);

        LettuceClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(timeout))
                .shutdownTimeout(Duration.ofMillis(shutDownTime))
                .poolConfig(genericObjectPoolConfig)
                .build();

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(database);
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(pwd));

        return new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
    }

    @Primary
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory);

        // replace JdkSerializationRedisSerializer with Jackson2JsonRedisSerializer
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // use string serializer as redis key serializer
        template.setKeySerializer(stringRedisSerializer);
        // use jackson serializer as redis value and hash value serializer
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

}
