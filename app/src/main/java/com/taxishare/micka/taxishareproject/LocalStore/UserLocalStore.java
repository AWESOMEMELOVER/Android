package com.taxishare.micka.taxishareproject.LocalStore;

import android.content.Context;
import android.content.SharedPreferences;

import com.taxishare.micka.taxishareproject.Entities.User;

/**
 * Created by micka on 11/4/2017.
 */

public class UserLocalStore {

    public static final String SP_NAME="userDetails";
    SharedPreferences userLocalDatabase;


    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.putInt("age",user.age);
        spEditor.commit();
    }
    public User getLogedInUser(){
        String name = userLocalDatabase.getString("name","");
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");
        int age = userLocalDatabase.getInt("age",-1);

        return new User(name,username,password,age);
    }
    public void setUserLoggedin(boolean isLogged){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",isLogged);
        spEditor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn",false)==true){
            return true;
        }else
            return false;
    }
}
