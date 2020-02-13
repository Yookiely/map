package com.yookie.map.config

import com.yookie.map.bean.HeatMap
import com.yookie.map.bean.WindRose
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import java.net.UnknownHostException
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer


@Configuration
open class MyRedisConfig {


    @Bean
    @Throws(UnknownHostException::class)
    open fun heatmapRedisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<Any, HeatMap> {
        val template = RedisTemplate<Any,HeatMap>()
        template.connectionFactory = redisConnectionFactory
        template.defaultSerializer = Jackson2JsonRedisSerializer(HeatMap::class.java)
        return template
    }

    @Bean
    open fun heatmapRedisCacheManager(factory: RedisConnectionFactory): RedisCacheManager {
        val config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer<HeatMap>(Jackson2JsonRedisSerializer(HeatMap::class.java))) //使用 Jackson2JsonRedisSerialize
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .transactionAware()
                .build()
    }

    @Bean
    @Throws(UnknownHostException::class)
    open fun windRoseRedisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<Any, WindRose> {
        val template = RedisTemplate<Any,WindRose>()
        template.connectionFactory = redisConnectionFactory
        template.defaultSerializer = Jackson2JsonRedisSerializer(WindRose::class.java)
        return template
    }

    @Bean
    open fun winRoseRedisCacheManager(factory: RedisConnectionFactory): RedisCacheManager {
        val config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer<WindRose>(Jackson2JsonRedisSerializer(WindRose::class.java))) //使用 Jackson2JsonRedisSerialize
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .transactionAware()
                .build()
    }

    @Primary
    @Bean
    open fun redisCacheManager(factory: RedisConnectionFactory): RedisCacheManager {
        val config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer<Any>(JdkSerializationRedisSerializer())) //使用 Jackson2JsonRedisSerialize
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .transactionAware()
                .build()
    }

}