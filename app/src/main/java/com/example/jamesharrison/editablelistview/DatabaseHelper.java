package com.example.jamesharrison.editablelistview;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
/**
 * Created by jamesharrison on 12/1/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    public final static String DATABASE_NAME = "mylist.db";
    public static final String TABLE_NAME = "mylist_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";





    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ITEM 1 TEXT)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP IF TABLE EXIST " + TABLE_NAME);
    }


    public boolean addData(String item1)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // content values to add data
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, item1);

        long result = db.insert(TABLE_NAME, null, contentValues);

        // if it didn't get inserted correctly
        if(result == -1)
        {
            return false;
        }

        else
        {
            return true;
        }
    }

    // get the contents of the database
    public Cursor getListContents()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        // select all the data from the table TABLE_NAME
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return data;
    }
}
