package com.example.stack;

import java.util.ArrayDeque;

/**
 * 猫狗队列：一般会使用一种带时间戳的方式实现。本实现貌似也没问题
 */
public class PetQueue {

    private ArrayDeque<Pet> petQueue = new ArrayDeque<>();
    private ArrayDeque<Cat> catQueue = new ArrayDeque<>();
    private ArrayDeque<Dog> dogQueue = new ArrayDeque<>();

    public void add(Pet pet) {
        petQueue.add(pet);
        if (pet instanceof Cat) {
            catQueue.add((Cat) pet);
        } else if (pet instanceof Dog) {
            dogQueue.add((Dog) pet);
        }
    }

    public Pet pollAll() {
        Pet pet = petQueue.poll();
        if (pet instanceof Cat) {
            catQueue.poll();
        } else if (pet instanceof Dog) {
            dogQueue.poll();
        }
        return pet;
    }

    public Dog pollDog() {
        petQueue.poll();
        return dogQueue.poll();
    }

    public Cat pollCat() {
        petQueue.poll();
        return catQueue.poll();
    }

    public boolean isEmpty() {
        return petQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public static void main(String[] args) {
        PetQueue petQueue = new PetQueue();
        Cat cat = new Cat();
        Dog dog = new Dog();
        petQueue.add(cat);
        petQueue.add(dog);
        System.out.println(petQueue.pollAll());
        System.out.println(petQueue.isCatEmpty());
        System.out.println(petQueue.pollDog());
        System.out.println(petQueue.isEmpty());
    }

}

class Pet {
    private String type;

    public String getType() {
        return type;
    }

    public Pet(String type) {
        this.type = type;
    }

}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat() {
        super("cat");
    }
}