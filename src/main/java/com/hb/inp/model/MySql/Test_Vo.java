package com.hb.inp.model.MySql;

public class Test_Vo {
    String test;
    String id;
    String name;

    public Test_Vo() {
    }

    public Test_Vo(String test, String id, String name) {
        this.test = test;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test_Vo{" +
                "test='" + test + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
