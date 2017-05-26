package com.test;

import com.learn.generic.Generic;
import com.learn.pojo.Person;

/**
 * Created by xia_yu on 2017/4/18.
 */
public class TestMain {
    public static void main(String[] args){
        Person person=new Person();
        person.setAge(20);
        person.setName("小明");
        person.setSex("男");
        Generic<Person> generic =new Generic<Person>();
        generic.setData(person);
        Person p=generic.getData();
        System.out.println(p.toString());

        Generic<?> name= new Generic<String>("小明");
        System.out.println(name.getData());

        Generic<?> age=new Generic<Integer>(20);
        System.out.println(age.getData());

    }
}
