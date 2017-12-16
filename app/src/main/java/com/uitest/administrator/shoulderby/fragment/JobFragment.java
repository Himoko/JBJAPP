package com.uitest.administrator.shoulderby.fragment;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.uitest.administrator.shoulderby.DBConnect.DBHelper;
import com.uitest.administrator.shoulderby.R;
import com.uitest.administrator.shoulderby.adapter.JobAdapter;
import com.uitest.administrator.shoulderby.bean.job;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 工作界面
 * Created by Administrator on 2017/12/6 0006.
 */

public class JobFragment extends Fragment {
    @Bind(R.id.tv_common_title)
    TextView tvCommonTitle;
    @Bind(R.id.lv_fragment_job)
    ListView lvFragmentJob;

    private List<job> jobList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_job, null);
        ButterKnife.bind(this, view);

        tvCommonTitle.setText("所有工作");
        initData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void initData(){
        jobList = new ArrayList<job>();
        DBHelper dbHelper = new DBHelper(getActivity(),1);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query("jobItem",null,null,null,null,null,null);
        while(cursor.moveToNext()){
            //获取数据存储到jobList中
            String pic = cursor.getString(1);
            String title = cursor.getString(2);
            String content = cursor.getString(3);
            String money = cursor.getString(cursor.getColumnIndex("money"));
            jobList.add(new job(1,title,content,money));
        }
        cursor.close();
        database.close();
        JobAdapter jobAdapter = new JobAdapter(jobList);
        lvFragmentJob.setAdapter(jobAdapter);
    }
}
