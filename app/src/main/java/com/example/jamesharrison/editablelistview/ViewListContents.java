package com.example.jamesharrison.editablelistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jamesharrison on 12/3/16.
 */

public class ViewListContents extends AppCompatActivity
{

    DatabaseHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewcontents_layout);


        ListView listView = (ListView) findViewById(R.id.listView);

        myDB = new DatabaseHelper(this);


        // populate an arraylist from database and adapt to a list adapter
        ArrayList<String> theList = new ArrayList<>();

        // this cursor references the database and used the method getListContent to get all content of the database
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0)
        {
            Toast.makeText(ViewListContents.this, "The Database was Empty", Toast.LENGTH_SHORT).show();
        }

        else
        {
            while(data.moveToNext())
            {
                // add the content to the list view, the 1 means index 1 in the DB which is the item
                theList.add(data.getString(1));

                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);

                listView.setAdapter(listAdapter);


            }
        }
    }
}
