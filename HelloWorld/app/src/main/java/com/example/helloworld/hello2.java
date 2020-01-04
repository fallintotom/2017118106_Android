package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class hello2 extends AppCompatActivity {
    private String TAG = "Hello2";
    private static int ObjCount = 0;
    private int mObjCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);
        Button bthello2 = (Button) findViewById(R.id.bthello2);
        Button bthello3 = (Button) findViewById(R.id.bthello3);
        Button stayhello2 = (Button) findViewById(R.id.stayhello2);
        ObjCount++;
        mObjCount = ObjCount;
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
