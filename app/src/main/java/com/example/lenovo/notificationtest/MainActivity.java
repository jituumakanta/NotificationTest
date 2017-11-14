package com.example.lenovo.notificationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notification=findViewById(R.id.notification);
        Button customnotification=findViewById(R.id.customnotification);


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notificationobj=new Notification(getApplicationContext());
                 notificationobj.Notification();//default notification
            }
        });
        customnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notificationobj=new Notification(getApplicationContext());
                notificationobj.CustomNotification();//custome notification
            }
        });

    }
}
