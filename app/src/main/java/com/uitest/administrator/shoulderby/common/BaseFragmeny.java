package com.uitest.administrator.shoulderby.common;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uitest.administrator.shoulderby.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class BaseFragmeny extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        ButterKnife.bind(this, view);


        return view;
    }
}
