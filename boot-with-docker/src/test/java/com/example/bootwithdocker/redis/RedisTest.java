package com.example.bootwithdocker.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class RedisTest {
    @Qualifier("normal")
    @Autowired
    private RedisTemplate<String, Object> template;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private HashMapping hashMapping;

    @Test
    public void testRedisTemplate() {
        String key = "key1";
        String value = "hello";
        template.opsForValue().set(key, value);
        assertEquals(template.opsForValue().get(key), value);
    }

    @Test
    public void testStringRedisTemplate() {
        String key = "key2";
        String value = "hello";
        stringRedisTemplate.opsForValue().set(key, value);
        assertEquals(stringRedisTemplate.opsForValue().get(key), value);
    }

    @Test
    public void testHashMapping() {
        Person person = new Person();
        person.setName("david");
        person.setAge(20);
        String key = "hash_key2";
        hashMapping.writeHash(key, person);
        System.out.println(hashMapping.loadHash(key));
    }

    @Test
    public void testSetObject() {
        Person person = new Person();
        person.setName("david");
        person.setAge(20);
        Address address = new Address();
        address.setCity("beijing");
        person.setAddress(address);
        template.setKeySerializer(RedisSerializer.string());
        // 使用JdkSerializationRedisSerializer序列化
        template.opsForValue().set("jdk/key1", person);
        System.out.println(template.opsForValue().get("jdk/key1"));

        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Person.class));
        template.opsForValue().set("json/key1", person);
        System.out.println(template.opsForValue().get("json/key1"));
        Person person1 = (Person) template.opsForValue().get("json/key1");
        System.out.println(person1.getAddress().getCity());

    }

    @Test
    public void testPubSub() throws InterruptedException {
        String channel = "test_channel";
        template.convertAndSend(channel, "hello");
        Thread.sleep(10000);
    }

}