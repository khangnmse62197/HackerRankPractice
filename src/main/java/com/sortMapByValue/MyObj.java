package main.java.com.sortMapByValue;

import java.io.Serializable;
import java.util.Objects;

public class MyObj implements Comparable<MyObj>, Serializable {
    private String name;
    private Integer age;

    public MyObj(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(MyObj o) {
        return o.getAge().compareTo(this.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObj myObj = (MyObj) o;
        return Objects.equals(name, myObj.name) && Objects.equals(age, myObj.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "MyObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}