//WID(27/8/2026)(Sarthak Mittal)(CacheConfigLoader)
package com.kafka.Carofly.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.caffeine.CaffeineCacheManager;
@EnableCaching
@Configuration
public class CacheConfigLoader{
    @Bean
    public CaffieneCacheManager caffieneCacheManager(){
        CaffeineCacheManager caffeineCacheManager=new CaffeineCacheManager();
    }

}