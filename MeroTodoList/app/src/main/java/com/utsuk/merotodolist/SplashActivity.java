package com.utsuk.merotodolist;
/*
 * Utsuk Paudayal
 * C7227233
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                //allows to save and retrieve data in the form of key value pair
                //
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("todo_pref", 0);
                Boolean authentication = preferences.getBoolean("authentication", false);
                if(authentication){
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class
                    );
                    startActivity(intent);
                }else{
                    Intent intent =  new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 7000);
    }
}


