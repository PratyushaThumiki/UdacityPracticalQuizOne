package com.example.thumikipratyusha.udacitypracticalquizone;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name, email, abt;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String yourself = "yourself";
    View view;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendMessage();
            }

        });
        name = (EditText) findViewById(R.id.t1);
        email = (EditText) findViewById(R.id.t2);
        abt = (EditText) findViewById(R.id.t3);
        sharedpreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, " "));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, " "));
        if (sharedpreferences.contains(yourself)) {
                abt.setText(sharedpreferences.getString(yourself, " "));

            }
            SharedPreferences.Editor editor = sharedpreferences.edit();
            String n = name.getText().toString();
            String e = email.getText().toString();
            String y = abt.getText().toString();
            editor.putString(Name, n);
            editor.putString(Email, e);
            editor.putString(yourself, y);
            editor.apply();

            if (savedInstanceState == null) {
                data = new ArrayList<String>();
            } else {
                data = savedInstanceState.getStringArrayList("data");
            }

        }
    }

    private void sendMessage() {

            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);

        }


    @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            int id = item.getItemId();
            if (id == R.id.action_favorite) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onSaveInstanceState (Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putStringArrayList("data", data);
        }

}