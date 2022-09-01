package com.sf.demo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.sf.demo.entity.User;

import java.util.concurrent.TimeUnit;

/**
 * Caffeine Demo
 */
public class CaffeineCache {

    /**
     * 基础用法
     */
    public static void baseDemo() {
        Cache<String, Integer> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();

        String key = "sf";
        System.out.println(cache.getIfPresent(key));
        System.out.println(cache.get(key, k -> new Integer(18)));
        System.out.println(cache.getIfPresent(key));
        cache.put(key, new Integer(27));
        System.out.println(cache.getIfPresent(key));
        cache.invalidate(key);
        System.out.println(cache.getIfPresent(key));
    }

    /**
     * Loading用法
     */
    public static void loadingDemo(){
        CacheLoader<String, Integer> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build()
    }



    public static void main(String[] args) {
        baseDemo();
    }

}
