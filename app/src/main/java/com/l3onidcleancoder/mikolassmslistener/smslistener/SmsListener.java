package com.l3onidcleancoder.mikolassmslistener.smslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.List;

/**
 * Created by Leonid on 20.04.2014.
 */

public class SmsListener extends BroadcastReceiver {

    private final SmsExtractor smsExtractor = new SmsExtractor();
    private final SmsHandler smsHandler = new DummySmsHandler();

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();
            List<SmsMessage> smsMessages = smsExtractor.extractFrom(bundle);
            smsHandler.handle(context, smsMessages);
        }
    }
}