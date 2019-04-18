package com.example.sefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText studentUsername;
    EditText studentPassword;
    TextView registerLink;
    static TextView loginMessage;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentUsername = (EditText) findViewById(R.id.username);
        studentPassword = (EditText) findViewById(R.id.password);
        loginMessage = (TextView) findViewById(R.id.loginMessage);
        registerLink = (TextView) findViewById(R.id.registerLink);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentRegistration.class);
                startActivity(intent);
            }
        });
    }
    public void onLogin(View view){
        String studentId = studentUsername.getText().toString();
        String password = studentPassword.getText().toString();
        String type = "login";
        if(studentId.isEmpty() || password.isEmpty()){
            loginMessage.setText("Check Missing Input Value!!!");
        }else{
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, studentId, password);
        }
    }
}
