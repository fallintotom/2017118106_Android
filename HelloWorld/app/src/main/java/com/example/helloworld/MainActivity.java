package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private String TAG = "Hello1";
    private static int ObjCount = 0;
    private int mObjCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bthello1 = (Button) findViewById(R.id.bthello1);
        Button bthello3 = (Button) findViewById(R.id.bthello3);
        Button stayhello1 = (Button) findViewById(R.id.stayhello1);
        ObjCount++;
        mObjCount = ObjCount;
        bthello1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"You clicked tohello2 button!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, hello2.class);
                    startActivity(intent);
                }
        }
        );
        bthello3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You clicked tohello3 button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, hello3.class);
                startActivity(intent);
            }
        }
        );
        stayhello1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You clicked stayhello1 button!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
        );
        setTitle("Hello1");
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
            Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
            break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }
}
