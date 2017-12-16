package com.uitest.administrator.shoulderby.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.uitest.administrator.shoulderby.R;
import com.uitest.administrator.shoulderby.activity.ChatViewActivity;
import com.uitest.administrator.shoulderby.adapter.ChatAdapter;
import com.uitest.administrator.shoulderby.bean.Chat_item;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 聊天界面
 * Created by Administrator on 2017/12/6 0006.
 */

public class ChatFragment extends Fragment implements AdapterView.OnItemClickListener {
    @Bind(R.id.tv_common_title)
    TextView tvCommonTitle;
    @Bind(R.id.rb_chat_mag)
    RadioButton rbChatMag;
    @Bind(R.id.rb_chat_contacts)
    RadioButton rbChatContacts;
    @Bind(R.id.rg_chat_choose)
    RadioGroup rgChatChoose;
    @Bind(R.id.sv_chat_search)
    SearchView svChatSearch;
    @Bind(R.id.lv_chat)
    ListView lvChat;

    private List<Chat_item> chatItems;      //用于存储数据

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_chat, null);
        ButterKnife.bind(this, view);

        tvCommonTitle.setText("消息");
        initData();
        lvChat.setOnItemClickListener(this);
        return view;
    }
    //初始化数据
    public void initData() {
        chatItems = new ArrayList<Chat_item>();
        chatItems.add(new Chat_item(R.drawable.head4,"客服GG","您好，为您服务！"));
        chatItems.add(new Chat_item(R.drawable.head3,"客服MM","欢迎您使用兼并兼！"));
        ChatAdapter adapter = new ChatAdapter(chatItems);
        lvChat.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    //设置点击监听
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), ChatViewActivity.class);
        startActivity(intent);
    }
}
