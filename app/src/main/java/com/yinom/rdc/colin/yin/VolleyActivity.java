package com.yinom.rdc.colin.yin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.yinom.rdc.colin.yin.network.MyApplication;
import com.yinom.rdc.colin.yin.network.VolleyInterface;
import com.yinom.rdc.colin.yin.network.VolleyRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends Activity implements View.OnClickListener {
    EditText ettPhoneNumber;
    TextView ttvNotice;
    Button btnVolleyQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        btnVolleyQuery=(Button) findViewById(R.id.btnVolleyQuery);
        ettPhoneNumber = (EditText) findViewById(R.id.ettVolleyPhoneNumber);
        ttvNotice = (TextView) findViewById(R.id.ttvVolleyNotice);

        btnVolleyQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnVolleyQuery:
                StringRequest_Get();
                break;
        }
    }

    /**
     * Volley StringRequest
     * GET method
     */
    private void StringRequest_Get() {
        String url = "http://apis.juhe.cn/mobile/get?phone=" + ettPhoneNumber.getText().toString() +
                "&key=1b27ee246b8392716f924692cc241d25";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response
                .Listener<String>() {
            @Override
            public void onResponse(String response) {
                ttvNotice.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ttvNotice.setText(error.toString());
            }
        });
        stringRequest.setTag("StringRequest_Get");
        MyApplication.getHttpQueue().add(stringRequest);
    }

    /**
     * 使用二次封装对 Volley String Request GET method改造
     */
    private void stringRequest_Get() {
        String url = "http://apis.juhe.cn/mobile/get?phone=" + ettPhoneNumber.getText().toString() +
                "&key=1b27ee246b8392716f924692cc241d25";
        VolleyRequest.StringRequestGet(this, url, "StringRequest_Get", new VolleyInterface(this,
                VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                ttvNotice.setText(result);
            }

            @Override
            public void onMyError(VolleyError error) {
                ttvNotice.setText(error.toString());
            }
        });
    }

    /**
     * Volley StringRequest
     * POST method
     */
    private void StringRequest_Post() {
        String url = "http://apis.juhe.cn/mobile/get";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response
                .Listener<String>() {
            @Override
            public void onResponse(String response) {
                ttvNotice.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ttvNotice.setText(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("phone", ettPhoneNumber.getText().toString());
                hashMap.put("key", "1b27ee246b8392716f924692cc241d25");
                return hashMap;
            }
        };
        stringRequest.setTag("StringRequest_Post");
        MyApplication.getHttpQueue().add(stringRequest);
    }

    /**
     * Volley JsonObjectGet
     * GET method
     */
    private void JsonObjectRequest_Get() {
        String url = "http://apis.juhe.cn/mobile/get?phone=" + ettPhoneNumber.getText().toString() +
                "&key=1b27ee246b8392716f924692cc241d25";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new
                Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ttvNotice.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ttvNotice.setText(error.toString());
            }
        });
        jsonObjectRequest.setTag("JsonObjectRequest_Get");
        MyApplication.getHttpQueue().add(jsonObjectRequest);
    }

    /**
     * Volley JsonObjectRequest
     * POST method
     */
    private void JsonObjectRequest_Post() {
        String url = "http://apis.juhe.cn/mobile/get";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new
                Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ttvNotice.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ttvNotice.setText(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("phone", ettPhoneNumber.getText().toString());
                hashMap.put("key", "1b27ee246b8392716f924692cc241d25");
                return hashMap;
            }
        };
        jsonObjectRequest.setTag("JsonObjectRequest_Post");
        MyApplication.getHttpQueue().add(jsonObjectRequest);
    }

    /**
     * Volley JsonArrayRequest
     * GET Method
     */
    private void JsonArrayRequest_Get() {
        String url = "http://apis.juhe.cn/mobile/get?phone=" + ettPhoneNumber.getText().toString() +
                "&key=1b27ee246b8392716f924692cc241d25";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new
                Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ttvNotice.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ttvNotice.setText(error.toString());
            }
        });
        jsonArrayRequest.setTag("JsonArrayRequest_Get");
        MyApplication.getHttpQueue().add(jsonArrayRequest);
    }

    /**
     * Volley JsonArrayRequest
     * POST method
     */
    private void JsonArrayRequest_Post() {
        String url = "http://apis.juhe.cn/mobile/get";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, new
                Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ttvNotice.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ttvNotice.setText(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("phone", ettPhoneNumber.getText().toString());
                hashMap.put("key", "1b27ee246b8392716f924692cc241d25");
                return hashMap;
            }
        };
        jsonArrayRequest.setTag("JsonArrayRequest_Post");
        MyApplication.getHttpQueue().add(jsonArrayRequest);
    }

    /**
     * Volley与Activity生命周期关联
     */
    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getHttpQueue().cancelAll("StringRequest_Get");
    }
}
