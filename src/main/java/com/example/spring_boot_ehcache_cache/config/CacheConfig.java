package com.example.spring_boot_ehcache_cache.config;

import java.net.URISyntaxException;

import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cacheManager -> cacheManager.createCache("myCache", new MutableConfiguration<>()
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.TEN_MINUTES))
                .setStoreByValue(false));
    }

    @Bean
    public CacheManager cacheManager() throws URISyntaxException {
        javax.cache.CacheManager cacheManager = Caching.getCachingProvider()
                .getCacheManager(getClass().getResource("/ehcache.xml").toURI(), getClass().getClassLoader());
        return new JCacheCacheManager(cacheManager);
    }
}
