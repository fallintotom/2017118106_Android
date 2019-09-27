package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class hello3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        Button bthello4 = findViewById(R.id.bthello4);
        Button bthello5 = findViewById(R.id.bthello5);
        Button bthello6 = findViewById(R.id.bthello6);
        bthello4.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
             Toast.makeText(hello3.this,"You clicked tohello1 button!", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(hello3.this, MainActivity.class);
             startActivity(intent);
             }
        }
        );
        bthello5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(hello3.this,"You clicked tohello2 button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(hello3.this, hello2.class);
                startActivity(intent);
            }
        }
        );
        bthello6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(hello3.this,"You clicked stayhello3 button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(hello3.this, hello3.class);
                startActivity(intent);
            }
        }
        );
        setTitle("Hello3");
    }
}
