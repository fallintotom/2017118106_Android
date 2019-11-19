package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class hello3 extends AppCompatActivity {
    private String TAG = "Hello3";
    private static int ObjCount = 0;
    private int mObjCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        Button bthello4 = findViewById(R.id.bthello4);
        Button bthello5 = findViewById(R.id.bthello5);
        Button bthello6 = findViewById(R.id.bthello6);
        ObjCount++;
        mObjCount = ObjCount;
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
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, mObjCount+"-onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, mObjCount+"-onResume: ");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, mObjCount+"-onPostResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, mObjCount+"-onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObjCount--;
        Log.d(TAG, mObjCount+"-onDestroy: ");
    }
}
