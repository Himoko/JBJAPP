package com.uitest.administrator.shoulderby.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uitest.administrator.shoulderby.R;
import com.uitest.administrator.shoulderby.fragment.ChatFragment;
import com.uitest.administrator.shoulderby.fragment.HomeFragment;
import com.uitest.administrator.shoulderby.fragment.JobFragment;
import com.uitest.administrator.shoulderby.fragment.MeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
    主界面
 */
public class MainActivity extends FragmentActivity {


    @Bind(R.id.fl_main_content)
    FrameLayout flMainContent;
    @Bind(R.id.iv_main_home)
    ImageView ivMainHome;
    @Bind(R.id.tv_main_home)
    TextView tvMainHome;
    @Bind(R.id.ll_main_home)
    LinearLayout llMainHome;
    @Bind(R.id.iv_main_job)
    ImageView ivMainJob;
    @Bind(R.id.tv_main_job)
    TextView tvMainJob;
    @Bind(R.id.ll_main_job)
    LinearLayout llMainJob;
    @Bind(R.id.iv_main_me)
    ImageView ivMainMe;
    @Bind(R.id.tv_main_me)
    TextView tvMainMe;
    @Bind(R.id.ll_main_me)
    LinearLayout llMainMe;
    @Bind(R.id.iv_main_chat)
    ImageView ivMainChat;
    @Bind(R.id.tv_main_chat)
    TextView tvMainChat;
    @Bind(R.id.ll_main_chat)
    LinearLayout llMainChat;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private MeFragment meFragment;
    private ChatFragment chatFragment;
    private JobFragment jobFragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化HOME界面，默认进入软件是HOME界面
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.fl_main_content, homeFragment);
        transaction.commit();
    }

    //设置点击监听事件
    @OnClick({R.id.ll_main_home, R.id.ll_main_me,R.id.ll_main_chat, R.id.ll_main_job})
    public void changeTab(View v) {
        transaction = fragmentManager.beginTransaction();
        //设置隐藏Fragment/图片/颜色
        hideFragment();
        switch (v.getId()) {
            case R.id.ll_main_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fl_main_content, homeFragment);
                }
                transaction.show(homeFragment);
                ivMainHome.setImageResource(R.drawable.bottom02);
                tvMainHome.setTextColor(getResources().getColor(R.color.home_back_selected));
                break;
            case R.id.ll_main_job:
                if (jobFragment == null) {  //当jobFragment不存在时，进行初始化
                    jobFragment = new JobFragment();
                    transaction.add(R.id.fl_main_content, jobFragment);     //添加jobFragment
                }
                transaction.show(jobFragment);  //显示jobFragment
                ivMainJob.setImageResource(R.drawable.bottom08);
                tvMainJob.setTextColor(getResources().getColor(R.color.home_back_selected));
                break;
            case R.id.ll_main_chat:
                if (chatFragment == null) {
                    chatFragment = new ChatFragment();
                    transaction.add(R.id.fl_main_content, chatFragment);
                }
                transaction.show(chatFragment);
                ivMainChat.setImageResource(R.drawable.bottom04);
                tvMainChat.setTextColor(getResources().getColor(R.color.home_back_selected));
                break;
            case R.id.ll_main_me:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.fl_main_content, meFragment);
                }
                transaction.show(meFragment);
                ivMainMe.setImageResource(R.drawable.bottom06);
                tvMainMe.setTextColor(getResources().getColor(R.color.home_back_selected));
                break;

        }
        transaction.commit();
    }

    //设置隐藏Fragment/图片/颜色
    private void hideFragment() {
        if (homeFragment != null) {
            ivMainHome.setImageResource(R.drawable.bottom01);
            tvMainHome.setTextColor(getResources().getColor(R.color.home_back_unselected));
            transaction.hide(homeFragment);
        }
        if (jobFragment != null) {
            ivMainJob.setImageResource(R.drawable.bottom07);
            tvMainJob.setTextColor(getResources().getColor(R.color.home_back_unselected));
            transaction.hide(jobFragment);
        }
        if (chatFragment != null) {
            ivMainChat.setImageResource(R.drawable.bottom03);
            tvMainChat.setTextColor(getResources().getColor(R.color.home_back_unselected));
            transaction.hide(chatFragment);
        }
        if (meFragment != null) {
            ivMainMe.setImageResource(R.drawable.bottom05);
            tvMainMe.setTextColor(getResources().getColor(R.color.home_back_unselected));
            transaction.hide(meFragment);
        }
    }

    private boolean flag = true;        //flag 用于判断是否是第一次点击返回键
    private static final int WHAT_RESET_BACK = 1;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_RESET_BACK:
                    flag = true;
                    break;
            }
        }
    };

    //重写onKeyDown，当点击两次返回键退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && flag) {
            Toast.makeText(this, "再点击一次，退出当前应用", Toast.LENGTH_SHORT).show();
            flag = false;
            handler.sendEmptyMessageDelayed(WHAT_RESET_BACK, 2000);     //设置2s的延迟，用于处理flag的值
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //为了避免内存泄漏，应该在Destroy（）移除未被执行的消息
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
