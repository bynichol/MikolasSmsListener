package com.l3onidcleancoder.mikolassmslistener.smslistener;

import android.os.Bundle;
import android.telephony.SmsMessage;

import com.l3onidcleancoder.mikolassmslistener.util.LogUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Leonid on 20.04.2014.
 */
public class SmsExtractor {

    public List<SmsMessage> extractFrom(Bundle bundle) {
        if (bundle != null) {
            try {
                return tryExtractFrom(bundle);
            } catch(Exception e){
                LogUtils.exception(e);
            }
        }
        return Collections.EMPTY_LIST;
    }

    private List<SmsMessage> tryExtractFrom(Bundle bundle) {
        Object[] pdus = (Object[]) bundle.get("pdus");
        List<SmsMessage> msgs = new ArrayList<SmsMessage>(pdus.length);
        for(int i = 0; i < pdus.length; i++){
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdus[i]);
            msgs.add(sms);
        }
        return msgs;
    }
}
