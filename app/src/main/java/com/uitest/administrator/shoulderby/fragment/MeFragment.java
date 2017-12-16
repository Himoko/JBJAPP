package com.uitest.administrator.shoulderby.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.uitest.administrator.shoulderby.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的界面
 * Created by Administrator on 2017/12/6 0006.
 */

public class MeFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.iv_me_head)
    ImageView ivMeHead;
    @Bind(R.id.tv_me_name)
    TextView tvMeName;
    @Bind(R.id.rb_me_jianzhi)
    RadioButton rbMeJianzhi;
    @Bind(R.id.rb_me_jianli)
    RadioButton rbMeJianli;
    @Bind(R.id.rb_me_shoucang)
    RadioButton rbMeShoucang;
    @Bind(R.id.rb_me_pianhao)
    RadioButton rbMePianhao;
    @Bind(R.id.rb_me_kefu)
    RadioButton rbMeKefu;
    @Bind(R.id.rb_me_fankui)
    RadioButton rbMeFankui;
    @Bind(R.id.rb_me_version)
    RadioButton rbMeVersion;
    @Bind(R.id.rb_me_set)
    RadioButton rbMeSet;
    @Bind(R.id.rg_me_choose)
    RadioGroup rgMeChoose;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_me, null);
        ButterKnife.bind(this, view);

        rgMeChoose.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.rb_me_jianzhi:
                Toast.makeText(getActivity(), "我的兼职", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_me_jianli:
                Toast.makeText(getActivity(), "我的简历", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_me_shoucang:
                Toast.makeText(getActivity(), "我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_me_pianhao:
                Toast.makeText(getActivity(), "我的偏好", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_me_kefu:
                Toast.makeText(getActivity(), "客服电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_me_fankui:
                Toast.makeText(getActivity(), "投诉与反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_me_version:
                Toast.makeText(getActivity(), "版本信息", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_me_set:
                Toast.makeText(getActivity(), "我的设置", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
