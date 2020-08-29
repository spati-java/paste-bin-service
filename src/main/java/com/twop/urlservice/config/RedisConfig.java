package com.twop.urlservice.config;

import com.twop.urlservice.Receiver;
import com.twop.urlservice.model.UrlData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String , UrlData> redisTemplate(){
        RedisTemplate<String , UrlData> template  =  new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return  template;
    }


    @Bean
    public HashOperations<String, String, UrlData> hashOperations(){
        return redisTemplate().opsForHash();
    }

    @Bean
    public Receiver receiver(){
        return  new Receiver();
    }




}
