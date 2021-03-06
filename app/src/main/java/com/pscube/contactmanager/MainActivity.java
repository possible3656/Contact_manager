package com.pscube.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.pscube.contactmanager.adapters.adapter;
import com.pscube.contactmanager.data.database;
import com.pscube.contactmanager.models.Contacts;
import com.pscube.contactmanager.util.utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    adapter adapter;
    ArrayList<Contacts> contactsArrayList ;
    ArrayAdapter<String> arrayAdapter ;
    Contacts contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactsArrayList = new ArrayList<>();
        final database database= new database(this);


        List<Contacts> contactsList = database.getContactsList();

        for (Contacts contacts : contactsList){


            Log.d("TAG", "onCreate: "+contacts.getName());

            contactsArrayList.add(contacts);

        }

        adapter= new adapter(this,contactsArrayList);

         recyclerView.setAdapter(adapter);


//        Contacts prateek= new Contacts();
//        prateek.setName("prateek");
//        prateek.setNumber("9413353369");


//
//        database.addContacts(new Contacts("shanti jain ","9413353369"));
//        database.addContacts(new Contacts("sunil kumar jain ","2323525353"));
//        database.addContacts(new Contacts("raman kumar ","934534553369"));
//        database.addContacts(new Contacts("sohail khan ","345345345345"));
//        database.addContacts(new Contacts("umang jain ", "9929394912"));
//        database.addContacts(new Contacts("raunak jain ", "6727828282"));
//        database.addContacts(new Contacts("chirag jain ", "99323223232"));
//        database.addContacts(new Contacts("piyush jain ", "9924453534534"));
//        database.addContacts(new Contacts("prateek jain ", "96724237383912"));

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





    }




}
