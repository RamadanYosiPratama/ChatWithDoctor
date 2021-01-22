package com.gmh.dokterlinkv2_1_1.Fragments;

import com.gmh.dokterlinkv2_1_1.Notifications.MyResponse;
import com.gmh.dokterlinkv2_1_1.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService
{
    @Headers({
            "Content-type:application/json",
            "Authorization:key=AAAA2s9YPiE:APA91bFLKV2xiLIZfdt3kvkUzHwMJrP6Evao_fUaEs2VGU6RJ0srMNxf07F0dTTsgaCW5-450jZuNjby_JtwHy3k_A1olnZBQ0FXiXzWDumhiSaPXSpM2HY9erAsfFw_hU0xIFOBgRA2"
    })

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
