package com.l3onidcleancoder.mikolassmslistener.smslistener;

import android.content.Context;
import android.telephony.SmsMessage;

import java.util.List;

/**
 * Created by Leonid on 20.04.2014.
 */
public interface SmsHandler {
    void handle(Context context, List<SmsMessage> smsMessages);
}
