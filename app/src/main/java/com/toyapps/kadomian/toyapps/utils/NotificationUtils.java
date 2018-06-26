package com.toyapps.kadomian.toyapps.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.toyapps.kadomian.toyapps.MainActivity;
import com.toyapps.kadomian.toyapps.R;

/**
 * Created by 10190270 on 6/26/2018.
 */

public class NotificationUtils {

    private static final int USB_ATTACHED_NOTIFICATION_ID = 1138;

    private static final int USB_ATTACHED_PENDING_INTENT_ID = 3417;

    private static final int ACTION_IGNORE_PENDING_INTENT_ID = 31217;
    private static final int ACTION_USB_ATTACHED_PENDING_INTENT_ID = 33217;

    private static final String USB_ATTACHED_NOTIFICATION_CHANNEL_ID = "usb_attached_channel";



    public static void clearAllNotificatins(Context context){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }


    public static void usbConnectedNotification(Context context) {



        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(USB_ATTACHED_NOTIFICATION_CHANNEL_ID,
                    "NotificationChannelName", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, USB_ATTACHED_NOTIFICATION_CHANNEL_ID)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(R.drawable.sc)
                .setLargeIcon(largeIcon(context))
                .setContentTitle("Camera Attached")
                .setContentText("New USB Camera Attached")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.notification_text)))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }

        notificationManager.notify(USB_ATTACHED_NOTIFICATION_ID, notificationBuilder.build());
    }




    private static Bitmap largeIcon(Context context) {

        Resources res = context.getResources();
        Bitmap largeIcon = BitmapFactory.decodeResource(res, R.drawable.sc);
        return largeIcon;
    }





    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, MainActivity.class);

        return PendingIntent.getActivity(context, ACTION_USB_ATTACHED_PENDING_INTENT_ID,
                startActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
