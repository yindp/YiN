package com.yinom.rdc.colin.yin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnTransferVolley).setOnClickListener(this);
        findViewById(R.id.btnLoadImage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTransferVolley:
                Intent volleyIntent = new Intent(MainActivity.this, VolleyActivity.class);
                startActivity(volleyIntent);
                break;
            case R.id.btnLoadImage:
                Intent imageIntent = new Intent(MainActivity.this, VolleyImage.class);
                startActivity(imageIntent);
                break;
        }
    }
}
