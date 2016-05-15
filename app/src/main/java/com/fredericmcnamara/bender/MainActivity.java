package com.fredericmcnamara.bender;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import java.io.InputStream;
import android.util.Log;

import java.util.List;
import android.widget.TextView;

import org.w3c.dom.Comment;

public class MainActivity extends AppCompatActivity {

    private UserDAO datasource;
    public  List<User> myList = new ArrayList<User>();
    public  List<User> robotsList = new ArrayList<User>();
    public int currentPos = 0;
    public String serializedObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        datasource = new UserDAO(this);
        datasource.open();

        User robot1 = new User("Bender", 18, "Lol", new String[] {"Eve", "Test"},"bender");
        User robot2 = new User("Wall-E", 18, "WAAAALLLLLL-EEE", new String[] {"Eve", "Test"},"walle");
        User robot3 = new User("BB-8", 18, "1101011101010", new String[] {"Eve", "Test"},"bb8");
        User robot4 = new User("Bender", 18, "Lol", new String[] {"Eve", "Test"},"bender");
        User robot5 = new User("Wall-E", 18, "WAAAALLLLLL-EEE", new String[] {"Eve", "Test"},"walle");
        User robot6 = new User("BB-8", 18, "1101011101010", new String[] {"Eve", "Test"},"bb8");

        myList.add(robot1);
        myList.add(robot2);
        myList.add(robot3);
        myList.add(robot4);
        myList.add(robot5);
        myList.add(robot6);

        serializedObject = "";
        for (int i = 0; i < myList.size(); i++) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                ObjectOutputStream so = new ObjectOutputStream(bo);
                so.writeObject(myList.get(i));


                so.flush();
                serializedObject = bo.toString("ISO-8859-1");
            } catch (Exception e) {
                System.out.println(e);
            }
            UserData user = null;
            user = datasource.createUser(serializedObject);
        }

        //robotsList = myList;

        List<UserData> values = datasource.getAllUsers();

        serializedObject = "";
        System.out.println(values.get(0).getUser());
        for (int i = 0; i < values.size(); i++) {
            try {
                serializedObject = values.get(i).getUser();
                byte b[] = serializedObject.getBytes("ISO-8859-1");
                ByteArrayInputStream bi = new ByteArrayInputStream(b);
                ObjectInputStream si = new ObjectInputStream(bi);
                User obj = (User) si.readObject();
                System.out.println(obj);
                robotsList.add(obj);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        TextView profileName = (TextView) findViewById(R.id.lblProfileName);
        profileName.setText(robotsList.get(0).getUsername());

    }

    public void likeButtonTap(View view) {
        if(currentPos >= (myList.size() - 1)) {
            TextView profileName = (TextView) findViewById(R.id.lblProfileName);
            profileName.setText("No other robots found around you...");
            ImageView imgProfil = (ImageView) findViewById(R.id.imgProfile);
            imgProfil.setImageResource(0);
        }
        else {
            currentPos++;
            TextView profileName = (TextView) findViewById(R.id.lblProfileName);
            profileName.setText(myList.get(currentPos).getUsername());
            ImageView imgProfil = (ImageView) findViewById(R.id.imgProfile);
           // imgProfil.setImageResource(R.drawable.);
            Resources res = getResources();
            String mDrawableName = myList.get(currentPos).getImageName();
            int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
            imgProfil.setImageResource(resID);
            Log.d("Debug", "Value: " + mDrawableName);
            //imgProfil.setImageResource(R.drawable.bb8);



        }
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

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

    public void viewProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
