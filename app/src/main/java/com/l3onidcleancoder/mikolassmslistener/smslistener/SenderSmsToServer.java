package com.l3onidcleancoder.mikolassmslistener.smslistener;

import android.content.Context;
import android.telephony.SmsMessage;

import com.l3onidcleancoder.mikolassmslistener.ui.settings.SmsReceiverNumberProvider;
import com.l3onidcleancoder.mikolassmslistener.ui.settings.WebServerAddressProvider;
import com.l3onidcleancoder.mikolassmslistener.util.LogUtils;
import com.l3onidcleancoder.mikolassmslistener.util.SimpleAsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Leonid on 22.04.2014.
 */
public class SenderSmsToServer implements SmsHandler {

    @Override
    public void handle(final Context context, final List<SmsMessage> smsMessages) {
        SimpleAsyncTask.run(new Runnable() {
            @Override
            public void run() {
                SmsSender smsSender = new SmsSender(context);
                smsSender.send(smsMessages);
            }
        });
    }

    private static class SmsSender {
        private final Context context;
        private final HttpClient httpClient;
        private final HttpPost httpPost;
        private SmsMessage currentSms;

        public SmsSender(Context context) {
            this.context = context;
            this.httpClient = new DefaultHttpClient();
            this.httpPost = new HttpPost(WebServerAddressProvider.get(context));
        }

        public void send(List<SmsMessage> smsMessages) {
            for (SmsMessage sms : smsMessages) {
                currentSms = sms;
                send();
            }
            currentSms = null;
        }

        private void send() {
            try {
                trySend();
            } catch (Throwable e) {
                LogUtils.exception(e);
            }
        }

        private void trySend() throws Exception {
            httpPost.setEntity(prepareEntity());
            httpClient.execute(httpPost);
        }

        private HttpEntity prepareEntity() throws UnsupportedEncodingException {
            List<? extends NameValuePair> args = Arrays.asList(
                new BasicNameValuePair(Constants.FROM, currentSms.getOriginatingAddress()),
                new BasicNameValuePair(Constants.TEXT, currentSms.getMessageBody()),
                new BasicNameValuePair(Constants.SMS_RECEIVER, SmsReceiverNumberProvider.get(context))
            );
            return new UrlEncodedFormEntity(args, HTTP.UTF_8);
        }
    }

}
