package com.pscube.contactmanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.pscube.contactmanager.R;
import com.pscube.contactmanager.models.Contacts;
import com.pscube.contactmanager.util.utils;

public class database extends SQLiteOpenHelper {
    public database(Context context) {
        super(context, utils.DATABASE_NAME, null, utils.DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_DATABASE_TABLE = " CREATE TABLE " + utils.TABLE_NAME +"(" +
                utils.KEY_ID+" INTEGER PRIMARY KEY,"+
                utils.KEY_NAME+" TEXT,"+
                utils.KEY_PHONE_NUMBER+" TEXT" +")";

        db.execSQL(CREATE_DATABASE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE = String.valueOf(R.string.drop_table);
        db.execSQL(DROP_TABLE, new String[]{utils.DATABASE_NAME});

        onCreate(db);
    }


    public void addContacts(Contacts contacts){

        SQLiteDatabase database = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(utils.KEY_NAME,contacts.getName());
        values.put(utils.KEY_PHONE_NUMBER,contacts.getNumber());


        database.insert(utils.TABLE_NAME,null,values);
        database.close();

    }


public  Contacts getContacts(int id){
        SQLiteDatabase database = this.getReadableDatabase();

    Cursor cursor= database.query(utils.TABLE_NAME,
            new String[]{utils.KEY_ID,utils.KEY_NAME,utils.KEY_PHONE_NUMBER},utils.KEY_ID+"=?",
            new String[]{String.valueOf(id)},
            null,null,null);


    if (cursor != null)
        cursor.moveToFirst();


    Contacts contacts = new Contacts();
    contacts.setId(Integer.parseInt(cursor.getString(0)));
    contacts.setName(cursor.getString(1));
    contacts.setNumber(cursor.getString(2));


    return contacts;


}

}
