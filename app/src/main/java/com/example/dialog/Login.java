package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    EditText etname , etpassword;

    Button login;
    Intent intent = new Intent();

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String nameVerify;
    String passwordVerify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                // Move SharedPreferences initialization here
                pref = getSharedPreferences("flag", MODE_PRIVATE);
                editor = pref.edit();
                nameVerify = pref.getString("name", "noadmin");
                passwordVerify = pref.getString("password", "noadmin");
                String names = "" , paswords = "";
                if(!etname.getText().toString().equals(""))
                {
                    names = etname.getText().toString().trim();
                }
                else
                {
                    Toast.makeText(Login.this, "Enter Your Name Please", Toast.LENGTH_SHORT).show();
                }

                if(!etpassword.getText().toString().equals(""))
                {
                    paswords = etpassword.getText().toString().trim();
                }
                else
                {
                    Toast.makeText(Login.this, "Enter Your Password Please", Toast.LENGTH_SHORT).show();
                }



                editor.putString("name", names);
                editor.putString("password", paswords);


                // Assuming 'nameVerify' and 'passwordVerify' are variables containing the values

//// Displaying a custom text with the value of 'nameVerify'
//                String customTextForName = "Name Verify: " + nameVerify;
//                Toast.makeText(Login.this, customTextForName, Toast.LENGTH_SHORT).show();
//
//// Displaying a custom text with the value of 'passwordVerify'
//                String customTextForPassword = "Password Verify: " + passwordVerify;
//                Toast.makeText(Login.this, customTextForPassword, Toast.LENGTH_SHORT).show();
                ;


                if(names.equals(nameVerify) && paswords.equals(passwordVerify))
                {
                    intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Login.this, "Some thing is wrong", Toast.LENGTH_SHORT).show();
                ;
            }
        });

    }

    void init(){

        etname = findViewById(R.id.name);
        etpassword = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }

}