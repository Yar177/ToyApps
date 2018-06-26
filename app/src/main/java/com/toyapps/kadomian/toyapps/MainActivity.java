package com.toyapps.kadomian.toyapps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_USB_ATTACHED  = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    ImageView usbImageView;
    IntentFilter mChargingIntentFilter;
    USBBroadcastReciver usbBroadcastReciver;

    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        UsbDevice device = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);

        usbImageView = (ImageView) findViewById(R.id.USBimageView);

        usbBroadcastReciver = new USBBroadcastReciver();

        //android.hardware.usb.action.USB_DEVICE_ATTACHED
    }


    public void testNotification(View view){
        //NotificationUtils.remindUserBecauseCharging(this    );

        mToast = Toast.makeText(this, "Cliked", Toast.LENGTH_SHORT);
        mToast.show();
    }




    private class USBBroadcastReciver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean isCharging = (action.equals(Intent.ACTION_POWER_CONNECTED));
            showCharging(isCharging);
        }
    }

    private void showCharging(boolean isChargin){

        if (isChargin){
            usbImageView.setImageResource(R.drawable.larg_Camera);
        }else {
            usbImageView.setImageResource(R.drawable.usb_xl);
        }
    }








}
