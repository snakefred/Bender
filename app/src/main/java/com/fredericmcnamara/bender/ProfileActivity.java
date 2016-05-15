package com.fredericmcnamara.bender;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        User curUser = (User) intent.getSerializableExtra("curUser");
        String name = (String) intent.getSerializableExtra("name");
        String age = (String) intent.getSerializableExtra("age");
        String desc = (String) intent.getSerializableExtra("desc");
        String imageName = (String) intent.getSerializableExtra("imageName");

        TextView profileName = (TextView) findViewById(R.id.lblName);
        profileName.setText(name);
        TextView profileAge = (TextView) findViewById(R.id.lblAge);
        profileAge.setText(age);
        TextView profileDesc = (TextView) findViewById(R.id.lblDesc);
        profileDesc.setText(desc);
        ImageView imgProfil = (ImageView) findViewById(R.id.imgProfile);
        Resources res = getResources();
        //String mDrawableName = imageName;
        int resID = res.getIdentifier(imageName , "drawable", getPackageName());
        imgProfil.setImageResource(resID);
        //Log.d("Debug", "Value: " + test);
    }
}
