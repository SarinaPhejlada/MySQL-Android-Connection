package com.example.sefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentHomePage extends AppCompatActivity {
    TextView logout;
    TextView welcome;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_page);
        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                name = null;
            }
            else{
                name = extras.getString("name");
            }
        }
        else{
            name = (String) savedInstanceState.getSerializable("name");
        }
        welcome = (TextView) findViewById(R.id.welcome);
        welcome.setText("Welcome, " + name);
        logout = (TextView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomePage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
