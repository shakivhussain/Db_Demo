package com.shakibmark.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.shakibmark.dbdemo.data.MyDbHandler;
import com.shakibmark.dbdemo.model.Contact;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyDbHandler db = new MyDbHandler(MainActivity.this);

        // Creating a contact object for the db
        Contact shakib = new Contact();
        shakib.setPhone_number("9090909090");
        shakib.setName("Shakib Mansoori");

        // Adding a contact to the db


        // Creating a contact object for the db
        Contact sarif = new Contact();
        sarif.setPhone_number("9090459090");
        sarif.setName("Sharif MAnsoori");


        /*** Update the existing contact */

        Contact tehri = new Contact();
        tehri.setId(28);
        tehri.setPhone_number(" change mo 9090675409");
        tehri.setName(" changed Tehri");

        // Adding a contact to the db

        db.addContact(shakib);
        db.addContact(sarif);

        db.deleteContactById(shakib);
        int affected_rows = db.updateContact(tehri);
        Log.d("dbharry", " No of affected rows " + affected_rows);

        Log.d("dbharry", "Id for tehri and larry are successfully added to the db");

        // Get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for(Contact contact: allContacts){
            Log.d("dbharry", "\n\n\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n"+
                    "Phone Number: " + contact.getPhone_number() + "\n" );


        }


    }
}
