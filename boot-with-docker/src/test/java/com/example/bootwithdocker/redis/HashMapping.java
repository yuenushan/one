package com.example.bootwithdocker.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;

public class HashMapping {

    @Qualifier("normal")
    @Autowired
    private RedisTemplate template;
    private HashMapper mapper = new Jackson2HashMapper(false);

    public void writeHash(String key, Person person) {
        template.opsForHash().putAll(key, mapper.toHash(person));
    }

    public Person loadHash(String key) {
        return (Person) mapper.fromHash(template.opsForHash().entries(key));
    }

}
