package com.hb.inp.model.MySql;

public class Test_Vo {
    String test;

    @Override
    public String toString() {
        return "Test_Vo{" +
                "test='" + test + '\'' +
                '}';
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
