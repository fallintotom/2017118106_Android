package cn.edu.hstc.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int UPDATE_TEXT = 1;
    private TextView text;
    public static int counter = 0;
    String TAG = "子线程数：";
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:               //在这里可以进行UI操作
                    text.setText("子线程数： "+counter);
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        Button changeText= (Button) findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (counter<50) {
                            counter+=1;
                            Log.d(TAG, String.valueOf(counter));
                            Thread.sleep(3000);
                            Message message = new Message();
                            message.what = UPDATE_TEXT;
                            handler.sendMessage(message);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_text:
                counter=counter-1;
                Log.d(TAG, String.valueOf(counter));
                Message message = new Message();
                message.what = UPDATE_TEXT;
                handler.sendMessage(message);
                break;
            default:
                break;
        }
    }
}
