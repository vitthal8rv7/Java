package com.learn.java.junit5.record;

public record Employee(String id, String name, Integer age) {
//    public Employee(String id, String name, Integer age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }


    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Integer age() {
        return age;
    }
}
