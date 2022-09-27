package com.mmh.content.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiangyiheng
 * @date 2022-09-08 8:42
 */
@Configuration
public class LogConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.HEADERS;
    }
}