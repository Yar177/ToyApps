package com.toyapps.kadomian.toyapps;

import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_USB_ATTACHED  = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        UsbDevice device = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);

        //android.hardware.usb.action.USB_DEVICE_ATTACHED



    }
}
