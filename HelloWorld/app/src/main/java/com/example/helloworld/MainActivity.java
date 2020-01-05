package com.example.helloworld;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        MenuItem call_item = (MenuItem) findViewById(R.id.call_item);
        MenuItem surf_item = (MenuItem) findViewById(R.id.surf_item);
        MenuItem map_item = (MenuItem) findViewById(R.id.map_item) ;
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
            case R.id.call_item:
            Toast.makeText(this,"You clicked Call Button!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
            break;
            case R.id.surf_item:
                Toast.makeText(this,"Turning to network...",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://baidu.com"));
                startActivity(intent1);
                break;
            case R.id.map_item:
                Toast.makeText(this,"Turning to map...",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("google.navigation:q=\" + ll.latitude + \",\" + ll.longitude"));
                intent2.setPackage("com.google.android.apps.maps");
                try{
                    startActivity(intent2);
                } catch(ActivityNotFoundException e) {
                    Toast.makeText(this, "找不到对应的Activity", Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
        return true;
    }
}
