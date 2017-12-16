package com.uitest.administrator.shoulderby.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uitest.administrator.shoulderby.R;
import com.uitest.administrator.shoulderby.bean.Chat_item;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/9 0009.
 */

public class ChatAdapter extends BaseAdapter {

    private List<Chat_item> chatItem;
    public ChatAdapter(List<Chat_item> chatItem){
        this.chatItem = chatItem;
    }
    @Override
    public int getCount() {
        return chatItem.size();
    }

    @Override
    public Object getItem(int position) {
        return chatItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_chat_chat, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //装载数据
        Chat_item chat_item = chatItem.get(position);
        viewHolder.ivChatHead.setImageResource(chat_item.getHead());
        System.out.println("==========index: " + chat_item.getHead());
        viewHolder.tvChatitemName.setText(chat_item.getUsername());
        viewHolder.tvChatitemContent.setText(chat_item.getContent());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_chat_head)
        ImageView ivChatHead;
        @Bind(R.id.tv_chatitem_name)
        TextView tvChatitemName;
        @Bind(R.id.tv_chatitem_content)
        TextView tvChatitemContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
