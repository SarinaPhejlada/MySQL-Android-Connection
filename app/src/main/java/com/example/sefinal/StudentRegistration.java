package com.example.sefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentRegistration extends AppCompatActivity {
    EditText studentUsername, studentFirstName, studentLastName, studentPassword;
    TextView registerMessage;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        studentUsername = (EditText)findViewById(R.id.username);
        studentFirstName = (EditText)findViewById(R.id.firstName);
        studentLastName = (EditText)findViewById(R.id.lastName);
        studentPassword = (EditText)findViewById(R.id.password);
        registerMessage = (TextView)findViewById(R.id.registerMsg);
        registerBtn = (Button)findViewById(R.id.registerBtn);
    }
    public void onRegistration(View view){
        String username = studentUsername.getText().toString();
        String firstName = studentFirstName.getText().toString();
        String lastName = studentLastName.getText().toString();
        String password = studentPassword.getText().toString();
        String type = "register";
        if(username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty())
            registerMessage.setText("Check Missing Input Value!!");
        else{
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, firstName, lastName, password);
        }
    }
}
