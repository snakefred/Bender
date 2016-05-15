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

        TextView profileName = (TextView) findViewById(R.id.lblName);
        profileName.setText(curUser.getUsername());
        TextView profileAge = (TextView) findViewById(R.id.lblAge);
        profileAge.setText(curUser.getAge());
        TextView profileDesc = (TextView) findViewById(R.id.lblDesc);
        profileDesc.setText(curUser.getUsername());
        ImageView imgProfil = (ImageView) findViewById(R.id.imgProfile);
        Resources res = getResources();
        String mDrawableName = curUser.getImageName();
        int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        imgProfil.setImageResource(resID);
        Log.d("Debug", "Value: " + mDrawableName);
    }
}
