package com.example.jamesharrison.editablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper myDB;

    Button btnAdd, btnView;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnView = (Button) findViewById(R.id.btnView);

        // when the add button is clicked
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get the text from the edit text
                String newEntry = editText.getText().toString();

                // if the edit text is not empty
                if(editText.length() != 0)
                {
                    // add the data to the database
                    AddData(newEntry);

                    //set the text back to blank
                    editText.setText("");
                }

                // if the hit add and it was empty
                else
                {
                    // Display message
                    Toast.makeText(MainActivity.this, "Nothing to add", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    /////////11 min

    // Method to add data to the database
    public void AddData(String newEntry)
    {
        // refer to database and call method add data
        boolean insertData = myDB.addData(newEntry);

        // check to see if the insert to the database was successful
        if(insertData)
        {
            Toast.makeText(MainActivity.this, "Successfully Entered", Toast.LENGTH_LONG).show();
        }

        // if its not entered
        else
        {
            Toast.makeText(MainActivity.this, "Not Entered", Toast.LENGTH_LONG).show();

        }

    }


}
