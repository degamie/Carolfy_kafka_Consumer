//WID(27/09/2026)(Sarthak Mittal)(CacheConfigLoader)#1.1.1
package com.kafka.Carofly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.caffeine.CaffeineCacheManager;
@EnableCaching
@Configuration
public class CacheConfigLoader{
    @Autowired
            public final ValueRetriever valueRetriever;
    CacheConfigLoader configLoader;

    CacheConfigLoader(CacheConfigLoader configLoader){
        this.configloader=configLoader;
    }
    @Bean
    public CaffeineCacheManager caffieneCacheManager(){
        CaffeineCacheManager  caffeineCacheManager=new CaffeineCacheManager();
        caffeineCacheManager.setCaffiene(caffeineCacheBuilder());
        return caffeineCacheManager;
    }
    public CacheModel listen(CacheEvent event){
        return new ConfigModel(event.getConfigkey(),event.getConfigValue());
    }

}