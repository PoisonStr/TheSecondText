package thesecondtext.example.com.thesecondtext;

import android.annotation.SuppressLint;
import android.media.ImageReader;
import android.media.TimedMetaData;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;



public class Second3Activity extends AppCompatActivity {

    int[]imageIds=new int[]
            {
                    R.drawable.first,
                    R.drawable.second,
                    R.drawable.third,
                    R.drawable.forth,
                    R.drawable.firty
            };
    int currentImageId=0;
    private Message handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3);
        final  ImageView show1=(ImageView)findViewById(R.id.firty);
        final  ImageView show2=(ImageView)findViewById(R.id.second);
        final  ImageView show3=(ImageView)findViewById(R.id.third);
        final  ImageView show4=(ImageView)findViewById(R.id.forth);
        final  ImageView show5=(ImageView)findViewById(R.id.firty);
        Message  msg= handler.obtain();
       final Handler myHandler=new Handler()
        {
            public void handleMessage(Message msg)
            {
                if(msg.what==0x1233)
                {
                   show1.setImageResource(imageIds[currentImageId++%imageIds.length]);
                }
                super.handleMessage(msg);

            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run()
            {
                myHandler.sendEmptyMessage(0x1233);
            }
        },0,500);

    }
}
