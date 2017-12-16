package com.uitest.administrator.shoulderby.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uitest.administrator.shoulderby.R;
import com.uitest.administrator.shoulderby.bean.job;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class JobAdapter extends BaseAdapter {

    private List<job> jobList;

    public JobAdapter(List<job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public int getCount() {
        return jobList == null? 0 : jobList.size();
    }

    @Override
    public Object getItem(int position) {
        return jobList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_job, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //装载数据
        job job = jobList.get(position);
        viewHolder.ivItemPic.setImageResource(R.drawable.job_item_pic);
        viewHolder.tvItemTitle.setText(job.getTitle());
        viewHolder.tvItemContent.setText(job.getContent());
        viewHolder.tvItemMoney.setText(job.getMoney());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_item_pic)
        ImageView ivItemPic;
        @Bind(R.id.tv_item_title)
        TextView tvItemTitle;
        @Bind(R.id.tv_item_money)
        TextView tvItemMoney;
        @Bind(R.id.tv_item_content)
        TextView tvItemContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
