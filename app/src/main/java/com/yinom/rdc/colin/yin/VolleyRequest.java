package com.yinom.rdc.colin.yin;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.yinom.rdc.colin.yin.network.MyApplication;

import java.util.Map;

/**
 * Created by Colin on 1/21/2016.
 * 对Volley的二次封装
 */
public class VolleyRequest {
    public static StringRequest stringRequest;
    public static Context context;

    public static void StringRequestGet(Context mContext, String url, String tag, VolleyInterface
            vif) {
        MyApplication.getHttpQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif
                .errorListener());
        stringRequest.setTag("StringRequest_Get");
        MyApplication.getHttpQueue().add(stringRequest);
        MyApplication.getHttpQueue().start();
    }

    public static void StringRequestPost(Context mContext, String url, String tag, final
    Map<String, String> params, VolleyInterface vif) {
        MyApplication.getHttpQueue().cancelAll(tag);
        stringRequest = new StringRequest(url, vif.loadingListener(), vif.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag("StringRequest_Post");
        MyApplication.getHttpQueue().add(stringRequest);
        MyApplication.getHttpQueue().start();
    }
}

