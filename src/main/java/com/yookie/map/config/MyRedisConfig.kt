package com.yookie.map.config

import com.yookie.map.bean.CityPositions
import com.yookie.map.bean.HeatMap
import com.yookie.map.bean.IsobaricLine
import com.yookie.map.bean.WindRose
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.net.UnknownHostException


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

    @Bean
    @Throws(UnknownHostException::class)
    open fun isobaricLineRedisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<Any, IsobaricLine> {
        val template = RedisTemplate<Any, IsobaricLine>()
        template.connectionFactory = redisConnectionFactory
        template.defaultSerializer = Jackson2JsonRedisSerializer(IsobaricLine::class.java)
        return template
    }

    @Bean
    open fun isobaricLineRedisCacheManager(factory: RedisConnectionFactory): RedisCacheManager {
        val config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer<IsobaricLine>(Jackson2JsonRedisSerializer(IsobaricLine::class.java))) //使用 Jackson2JsonRedisSerialize
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .transactionAware()
                .build()
    }

    @Bean
    @Throws(UnknownHostException::class)
    open fun positionsRedisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<Any, CityPositions> {
        val template = RedisTemplate<Any, CityPositions>()
        template.connectionFactory = redisConnectionFactory
        template.defaultSerializer = Jackson2JsonRedisSerializer(CityPositions::class.java)
        return template
    }

    @Bean
    open fun positionsRedisCacheManager(factory: RedisConnectionFactory): RedisCacheManager {
        val config = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer<CityPositions>(Jackson2JsonRedisSerializer(CityPositions::class.java))) //使用 Jackson2JsonRedisSerialize
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