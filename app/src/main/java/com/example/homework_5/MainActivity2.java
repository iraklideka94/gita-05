package com.example.homework_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView num;
EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        num = findViewById(R.id.textView2);
        msg = findViewById(R.id.editTextTextPersonName2);

        String nom1 = getIntent().getStringExtra("number");
        String nom2 = getIntent().getStringExtra("message");
        num.setText(nom1);
        msg.setText(nom2);
    }

    public void notifi(View view) {
        NotificationManager notificationManager = (NotificationManager) MainActivity2.this.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity2.this, channelId)
                .setLargeIcon(BitmapFactory.decodeResource(MainActivity2.this.getResources(), R.drawable.succes))
                .setSmallIcon(R.drawable.succes).setContentTitle("Notification from message up")
                .setContentText("Message sent!!");

        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity2.this, 0, intent, 0);
        mBuilder.setContentIntent(pendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());

        Intent int3 = new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(int3);
    }
}