package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

public class hello2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);
        Button bthello2 = (Button) findViewById(R.id.bthello2);
        Button bthello3 = (Button) findViewById(R.id.bthello3);
        Button stayhello2 = (Button) findViewById(R.id.stayhello2);
        bthello2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(hello2.this,"You clicked return button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(hello2.this, MainActivity.class);
                startActivity(intent);
            }
        }
        );
        bthello3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(hello2.this,"You clicked tohello3 button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(hello2.this, hello3.class);
                startActivity(intent);
            }
        });
        stayhello2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(hello2.this,"You clicked tohello3 button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(hello2.this, hello2.class);
                startActivity(intent);
            }
        });
        setTitle("Hello2");
    }
}
