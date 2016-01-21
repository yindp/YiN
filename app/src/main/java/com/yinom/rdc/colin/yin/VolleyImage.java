package com.yinom.rdc.colin.yin;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class VolleyImage extends AppCompatActivity {
    private ImageView iv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_image);
        initView();
        String url = "https://www.baidu.com/img/bdlogo.png";

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                iv_img.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.RGB_565, new Response
                .ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iv_img.setBackgroundResource(R.drawable.ICON);
            }
        });
    }

    private void initView() {
        iv_img = (ImageView) this.findViewById(R.id.iv_img);
    }
}




