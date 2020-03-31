package com.pscube.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.pscube.contactmanager.data.database;
import com.pscube.contactmanager.models.Contacts;
import com.pscube.contactmanager.util.utils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database database= new database(this);
        Log.d("count", "onCreate: "+database.getCount());


        Contacts prateek= new Contacts();
        prateek.setName("prateek");
        prateek.setNumber("9413353369");

      //  database.addContacts(prateek);


     //   Contacts preteel = database.getContacts(2);

       // database.deleteContact(preteel);
        //to get one contact at a time


//            Contacts c = database.getContacts(2);
//            c.setName("new Sambhav");
//            c.setNumber("9672422393");
        //     database.deleteContact(c);
//          int updatedRow =   database.updateContacts(c);
//
//        Log.d("mainActivity", "onCreate: "+updatedRow);



        //to get all contacts

            List<Contacts> contactsList = database.getContactsList();

            for (Contacts contacts : contactsList){


                Log.d("TAG", "onCreate: "+contacts.getName());


            }

    }


}
