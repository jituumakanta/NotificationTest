package com.example.lenovo.notificationtest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.WorkerThread;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Lenovo on 14-11-2017.
 */

public class Notification {

    Context context;

    public Notification(Context context) {
        this.context = context;
    }

    public void showNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Notifications Example")
                        .setContentText("This is a test notification");


        Intent notificationIntent = new Intent(context, Notification.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());


    }

    public  void Notification() {
        // Set Notification Title
        String strtitle = "notificationtitle";
        // Set Notification Text
        String strtext = "notificationtext";

        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(context, NotificationView.class);
        // Send data to NotificationView Class
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //Create Notification using NotificationCompat.Builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                // Set Icon
                .setSmallIcon(R.drawable.ic_launcher_background)
                // Set Ticker Message
                .setTicker("notificationticker")
                // Set Title
                .setContentTitle("notificationtitle")
                // Set Text
                .setContentText("notificationtext")
                // Add an Action Button below Notification
                .addAction(R.drawable.ic_launcher_foreground, "Action Button", pIntent)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Dismiss Notification
                .setAutoCancel(true);

        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());

    }

    public void CustomNotification() {
        // Using RemoteViews to bind custom layouts into Notification
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.customnotification);

        // Set Notification Title
        String strtitle = "customnotificationtitle";
        // Set Notification Text
        String strtext = "customnotificationtext";

        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(context, NotificationView.class);
        // Send data to NotificationView Class
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                // Set Icon
                .setSmallIcon(R.drawable.ic_launcher_background)
                // Set Ticker Message
                .setTicker("customnotificationticker")
                // Dismiss Notification
                .setAutoCancel(true)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Set RemoteViews into Notification
                .setContent(remoteViews);

        // Locate and set the Image into customnotificationtext.xml ImageViews
        remoteViews.setImageViewResource(R.id.imagenotileft,R.drawable.ic_launcher_background);
        remoteViews.setImageViewResource(R.id.imagenotiright,R.drawable.ic_launcher_foreground);

        // Locate and set the Text into customnotificationtext.xml TextViews
        remoteViews.setTextViewText(R.id.title,"customnotificationtitle");
        remoteViews.setTextViewText(R.id.text,"customnotificationtext");

        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());

    }

}
