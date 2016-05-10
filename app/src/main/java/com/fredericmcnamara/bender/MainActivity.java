package com.fredericmcnamara.bender;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private UserDAO datasource;
   public  List<UserData> myList=new ArrayList<UserData>();
    public int currentPos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        datasource = new UserDAO(this);
        datasource.open();

        List<UserData> values = datasource.getAllUsers();

//        UserData usertest1 = new UserData();
//        usertest1.UserData("Patate");
//        UserData usertest2 = new UserData();
//        usertest2.UserData("Steak");
//        UserData usertest3 = new UserData();
//        usertest3.UserData("Ble d'inde");


        UserData usertest1 = new UserData();
        usertest1.UserData("Patate");
        UserData usertest2 = new UserData();
        usertest2.UserData("Steak");
        UserData usertest3 = new UserData();
        usertest3.UserData("Ble d'inde");


        myList.add(usertest1);
        myList.add(usertest2);
        myList.add(usertest3);

        TextView profileName = (TextView) findViewById(R.id.lblProfileName);
        profileName.setText(myList.get(0).getUser());

    }

    public void likeButtonTap(View view) {
        if(currentPos >= (myList.size() - 1)) {
            currentPos = 0;
        }
        else {
            currentPos++;
        }
        TextView profileName = (TextView) findViewById(R.id.lblProfileName);
        profileName.setText(myList.get(currentPos).getUser());
        //Show
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void viewProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
