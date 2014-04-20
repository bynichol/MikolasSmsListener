package com.l3onidcleancoder.mikolassmslistener.smslistener;

import android.content.Context;
import android.telephony.SmsMessage;

import com.l3onidcleancoder.mikolassmslistener.ui.settings.SmsReceiverNumberProvider;
import com.l3onidcleancoder.mikolassmslistener.ui.settings.WebServerAddressProvider;
import com.l3onidcleancoder.mikolassmslistener.util.LogUtils;

import java.util.List;

/**
 * Created by Leonid on 20.04.2014.
 */
public class DummySmsHandler implements SmsHandler {
    @Override
    public void handle(Context context, List<SmsMessage> smsMessages) {
        LogUtils.debug("------------------");
        LogUtils.debug("<><><><><><><><><>");
        for (SmsMessage sms : smsMessages) {
            handle(context, sms);
        }
        LogUtils.debug("------------------");
    }

    private void handle(Context context, SmsMessage sms) {
        LogUtils.debug("***");
        LogUtils.debug("*  server:  " + WebServerAddressProvider.get(context));
        LogUtils.debug("*  from:    " + sms.getOriginatingAddress());
        LogUtils.debug("*  to:      " + SmsReceiverNumberProvider.get(context));
        LogUtils.debug("---------------------------");
        LogUtils.debug(sms.getMessageBody());
    }
}
