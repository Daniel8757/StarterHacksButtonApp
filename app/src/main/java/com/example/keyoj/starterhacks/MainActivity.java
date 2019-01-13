package com.example.keyoj.starterhacks;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // this is a comment guys.
    // I'M ADDING ANOTHER COMMENT!
    //YAY

    final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.print("Emergency!");

        Button send = (Button) findViewById(R.id.emergencyButton);

        send.setEnabled(false);

        if(checkPermission(Manifest.permission.SEND_SMS)){
            send.setEnabled(true);
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_REQUEST_CODE);
        }

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneNumber = "6472705503";
                String smsMessage = "Emergency!!!";

                if (checkPermission(Manifest.permission.SEND_SMS)) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, smsMessage, null, null);
                    Toast.makeText(getApplicationContext(),"SMS Sent!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"SMS Sending Failed!", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

}
