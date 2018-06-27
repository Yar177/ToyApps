package com.toyapps.kadomian.toyapps.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.util.Log;

/**
 * Created by 10190270 on 6/26/2018.
 */

public class USBBroadcastReceiver extends BroadcastReceiver {


    private static final String ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION";
    private static final String TAG = "USBBroadcastReceiver";
//    private final BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
//
//
//    };

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ACTION_USB_PERMISSION.equals(action)) {
            synchronized (this) {
                UsbDevice device = (UsbDevice)intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);

                if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                    if(device != null){
                        //call method to set up device communication
                    }
                }
                else {
                    Log.d(TAG, "permission denied for device " + device);
                }
            }
        }
    }
}
