package com.taxishare.micka.taxishareproject.Database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by micka on 05.11.2017.
 */

public class DatabaseManipulate {

    DatabaseReference databaseReference;
    String uniqueId;

    public DatabaseManipulate(String name){
        databaseReference = FirebaseDatabase.getInstance().getReference(name);
        uniqueId = databaseReference.push().getKey();
    }



    public void saveObjectToDatabase(Object object){
        databaseReference.child(uniqueId).setValue(object);
    }

    public String getUniqueId(){
        return uniqueId;
    }


}
