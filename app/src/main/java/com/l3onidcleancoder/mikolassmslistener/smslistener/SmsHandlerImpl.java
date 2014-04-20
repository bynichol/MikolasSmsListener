package com.l3onidcleancoder.mikolassmslistener.smslistener;

import android.content.Context;
import android.telephony.SmsMessage;

import java.util.List;

/**
 * Created by Leonid on 20.04.2014.
 */
public class SmsHandlerImpl implements SmsHandler {

    @Override
    public void handle(Context context, List<SmsMessage> smsMessages) {
        for (SmsMessage sms : smsMessages) {
            handle(context, sms);
        }
    }

    private void handle(Context context, SmsMessage sms) {
        // TODO
        throw new RuntimeException("Not implemented yet!");
    }
}
