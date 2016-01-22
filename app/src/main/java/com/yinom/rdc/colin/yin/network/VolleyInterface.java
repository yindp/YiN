package com.yinom.rdc.colin.yin.network;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;


public abstract class VolleyInterface {
    public Context mContext;
    public static Response.Listener<String> mListener;
    public static Response.ErrorListener mErrorListener;

    public VolleyInterface(Context context, Response.Listener<String> listener, Response
            .ErrorListener errorListener) {
        this.mContext = context;
        this.mListener = listener;
        this.mErrorListener = errorListener;
    }

    public abstract void onMySuccess(String result);

    public abstract void onMyError(VolleyError error);

    public Response.Listener<String> loadingListener() {
        mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //弹出加载中对话框
                onMySuccess(response);
            }
        };
        return mListener;
    }

    public Response.ErrorListener errorListener() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onMyError(error);
                //提示请求失败
            }
        };
        return mErrorListener;
    }
}
