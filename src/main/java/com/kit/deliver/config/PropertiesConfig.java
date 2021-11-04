package com.kit.deliver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @ClassName PropertiesConfig
 * @Description configuration of custom properties
 * @Author jihainan
 * @Date 2021/11/4 5:24 下午
 * @Version 1.0
 */
@Configuration
@PropertySource("classpath:custom-error.properties")
public class PropertiesConfig {
    private final Environment env;

    @Autowired
    public PropertiesConfig(Environment env) {
        this.env = env;
    }

    /**
     * @Author jihainan
     * @Description get config from env
     * @Date 12:33 上午 2021/11/5
     * @param configKey config name
     * @return java.lang.String
     */
    public String getConfigValue(String configKey) {
        return env.getProperty(configKey);
    }
}
