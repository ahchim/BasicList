package com.ahchim.android.basiclist;

/**
 * Created by Ahchim on 2017-01-31.
 */

public class User {
    private int id;
    private String name = "";
    private int age;

    public User(){
        id = 0;
        name = "";
        age = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
