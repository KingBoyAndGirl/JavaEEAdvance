package com.king.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.domain
 * @ClassName: Person
 * @Author: 王团结
 * @Description: 实体类
 * @Date: 2019/8/6 14:09
 * @Version: 1.0
 */
public class Person {

    private String name;
    private int age;
    private String gender;

//    @JsonIgnore   忽略属性
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date berthday;

    public Date getBerthday() {
        return berthday;
    }

    public void setBerthday(Date berthday) {
        this.berthday = berthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
