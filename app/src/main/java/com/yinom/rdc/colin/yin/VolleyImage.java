package com.yinom.rdc.colin.yin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.yinom.rdc.colin.yin.network.MyApplication;
import com.yinom.rdc.colin.yin.util.BitmapCache;

/**
 * 实现网络图片的加载
 */
public class VolleyImage extends AppCompatActivity {
    private ImageView iv_img;
    private NetworkImageView networkImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_image);
        initView();
        String url = "https://www.baidu.com/img/bdlogo.png";

        /**
         * 第一种实现方式
         */
        /*ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                iv_img.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.RGB_565, new Response
                .ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iv_img.setBackgroundResource(R.drawable.icon);
            }
        });
        imageRequest.setTag("ImageRequest_Get");
        MyApplication.getHttpQueue().add(imageRequest);*/

        /**
         * 第二种实现方式
         */
        /*
        ImageLoader loader=new ImageLoader(MyApplication.getHttpQueue(),new BitmapCache());
        ImageLoader.ImageListener listener=ImageLoader.getImageListener(iv_img,R.drawable.icon,R.drawable.icon);
        loader.get(url,listener);*/

        /**
         * 第三种实现方式
         */
        ImageLoader loader = new ImageLoader(MyApplication.getHttpQueue(), new BitmapCache());
        networkImageView.setDefaultImageResId(R.drawable.icon);
        networkImageView.setErrorImageResId(R.drawable.icon);
        networkImageView.setImageUrl(url, loader);
    }

    private void initView() {
        iv_img = (ImageView) this.findViewById(R.id.iv_img);
        networkImageView = (NetworkImageView) this.findViewById(R.id.networkImageView);
    }
}




