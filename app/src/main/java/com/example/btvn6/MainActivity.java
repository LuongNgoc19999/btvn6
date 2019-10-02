package com.example.btvn6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
EditText user, pass;
Button dn;
TextView quenmk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        dn = findViewById(R.id.login);
        quenmk = findViewById(R.id.quen);
        quenmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog  = new AlertDialog.Builder(MainActivity.this).setMessage(R.string.hihi)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "Ahihi!!!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        dn.setOnClickListener(new View.OnClickListener() {
            public  final String truepass = "^" + "(?=.*[0-9])"+"(?=.*[a-z])" + "(?=.*[!@#$%^&*])"+".{6,}"+"$";
            Pattern pattern = Pattern.compile(truepass);
            @Override
            public void onClick(View view) {

                if (user.getText().toString().length() == 0)
                {
                    Toast.makeText(getBaseContext(),"ban chua nhap ten dang nhap", Toast.LENGTH_LONG).show();
                }
                else if (user.getText().toString().equalsIgnoreCase("ngoc") == false){
                    Toast.makeText(getBaseContext(),"ban da nhap sai ten dang nhap, user:ngoc", Toast.LENGTH_LONG).show();
                }
                else
                if (pass.getText().toString().length() == 0)
                {Toast.makeText(getBaseContext(),"ban chua nhap mat khau", Toast.LENGTH_LONG).show();
                }
                else if (pass.getText().toString().length()<6){
                    Toast.makeText(getBaseContext(),"mat khau qua ngan", Toast.LENGTH_LONG).show();
                    pass.setText("");
                }
                else  if (pattern.matcher(pass.getText().toString()).matches()&& user.getText().toString().equalsIgnoreCase("ngoc")){
//else {
                    Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getBaseContext(),"mat khau sai", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}