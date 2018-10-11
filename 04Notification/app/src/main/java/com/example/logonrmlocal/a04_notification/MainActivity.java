package com.example.logonrmlocal.a04_notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exibirNotificacao(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "alertas";

            NotificationChannel notificationChannel = new NotificationChannel(channelId, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Channel Description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{ 0, 1000, 500, 1000 });
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "alertas");
            notification.setContentTitle("Alerta");
            notification.setChannelId(channelId);
            notification.setContentText("Não foi possível realizar o download.");
            notification.setSmallIcon(R.mipmap.ic_launcher);
            notification.setAutoCancel(true);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 99, new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pendingIntent);

            notificationManager.notify(100, notification.build());
        }
    }
}
