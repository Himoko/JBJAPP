package com.uitest.administrator.shoulderby.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.uitest.administrator.shoulderby.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
    软件启动欢迎界面
 */

public class WelcomeActivity extends AppCompatActivity {

    @Bind(R.id.iv_welcome_icon)
    ImageView ivWelcomeIcon;
    @Bind(R.id.tv_welcome_name)
    TextView tvWelcomeName;
    @Bind(R.id.tv_welcome_version)
    TextView tvWelcomeVersion;
    @Bind(R.id.rl_welcome)
    RelativeLayout rlWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        getSupportActionBar().hide();
        // 隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        Integer time = 2000;    //设置等待时间，单位为毫秒
        Handler handler = new Handler();
        //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();
            }
        }, time);
    }
}



