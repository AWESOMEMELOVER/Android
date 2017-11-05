package com.taxishare.micka.taxishareproject.Entities;

/**
 * Created by micka on 11/4/2017.
 */

public class User {

   public String name, username,password;
   public int age;

    public User(String name , String username , String password , int age){
        this.age=age;
        this.name=name;
        this.password=password;
        this.username = username;
    }
    public User(String username,String password){
        this.username=username;
        this.password=password;
        this.age=-1;
        this.name="";
    }

}
