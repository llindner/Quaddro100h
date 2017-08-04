package br.com.luizlindner.quaddro100h.lab15.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Mobile on 03/08/2017.
 */

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
        SmsMessage[] msgs = new SmsMessage[pdus.length];
        for(int i = 0; i < msgs.length; i++){
            msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
        }

        String msg = String.format(Locale.getDefault(), "%s %s", msgs[0].getOriginatingAddress(), msgs[0].getMessageBody());
        Log.i("LAB", msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
