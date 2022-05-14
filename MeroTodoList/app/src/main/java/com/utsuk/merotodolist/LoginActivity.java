package com.utsuk.merotodolist;
/*
 * Utsuk Paudayal
 * C7227233
 */
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    Button btnLogin, btnCancel;

    AlertDialog.Builder mAlterDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        txtUsername=findViewById(R.id.splash_txt_username);
        txtPassword= findViewById(R.id.splash_txt_password);

        btnLogin=findViewById(R.id.splash_btn_login);
        btnCancel=findViewById(R.id.splash_btn_cancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=txtUsername.getText().toString();
                String password=txtPassword.getText().toString();

                if(userName.equals("") || userName.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Name Cannot Be Null or Empty.", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals("") || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Password Cannot Be Null or Empty.", Toast.LENGTH_SHORT).show();

                }
                else{
                    if((userName.equals("admin")||userName.equals("ADMIN"))&&((password.equals("halamadrid")||password.equals("HALAMADRID")))){
                        SharedPreferences preferences = getApplicationContext().getSharedPreferences("todo_pref", 0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("authentication", true);
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Oopps, Sorry !!! \nInvalid User Name or Password.\nPlease Try Again.", Toast.LENGTH_LONG).show();                    }
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mAlterDialog = new AlertDialog.Builder(LoginActivity.this);
               mAlterDialog.setMessage(getString(R.string.quit_application))
                       .setCancelable(false)
                       .setTitle(getString(R.string.app_name))
                       .setIcon(R.mipmap.ic_launcher);
               mAlterDialog.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       System.exit(0);
                   }
               });
               mAlterDialog.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               });
               mAlterDialog.show();
            }
        });

    }
}