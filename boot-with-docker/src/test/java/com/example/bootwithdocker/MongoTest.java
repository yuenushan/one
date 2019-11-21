package com.example.bootwithdocker;

import com.mongodb.client.MongoClients;
import org.junit.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class MongoTest {

    private static final Log log = LogFactory.getLog(MongoTest.class);

    @Test
    public void test() {
        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "database");
        mongoOps.insert(new Person("Joe", 34));

        log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));

        mongoOps.dropCollection("person");
    }
}

class Person {
    private String id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
