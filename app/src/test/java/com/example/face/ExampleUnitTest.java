package com.example.face;

import android.util.Log;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private String http = "HTTP_______";
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    private String testHttp = "Http________";
    @Test
    public void httpGetTest(){
        //Log.d(testHttp, "GetTest___");
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .get()
                .url(NetAddress.testUrl)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
               // Log.d(testHttp, "Thread___");
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        System.out.println("succeed");
                        //Log.d(testHttp, "succeed___" + response.headers().toString());
                        System.out.println(response.body().string());
                    }else{
                        System.out.println("failed");
                        //Log.d(testHttp, "failed___");
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}