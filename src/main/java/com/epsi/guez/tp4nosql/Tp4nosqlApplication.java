package com.epsi.guez.tp4nosql;

import com.epsi.guez.tp4nosql.model.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class Tp4nosqlApplication {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Note> redisTemplate() {
        RedisTemplate<String, Note> redisTemplate = new RedisTemplate<String, Note>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }


    public static void main(String[] args) {
        SpringApplication.run(Tp4nosqlApplication.class, args);
    }
}
