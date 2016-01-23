package com.zju.yibao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Atlas on 15/12/16.
 */
public class MyFragment2 extends android.app.Fragment implements View.OnClickListener {

    private View root;
    private CircleImageView user_image;

    private ListView listView;
    List<Map<String, Object>> listItems;
    private SimpleAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_show_2, null);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        listItems = new ArrayList<>();
        initData();
        initAdapter();
        listView.setAdapter(adapter);
    }

    private void initView() {
        user_image = (CircleImageView) root.findViewById(R.id.user_image);
        user_image.setOnClickListener(this);
        listView = (ListView) root.findViewById(R.id.list);
    }

    private void shake(View view) {
        final TranslateAnimation anim = new TranslateAnimation(0, 10, 0, 0);
        anim.setInterpolator(new CycleInterpolator(2f));
        anim.setDuration(300);
        view.startAnimation(anim);
    }

    private void initData() {
        int[] icons = new int[]{
                R.drawable.icon_course,
                R.drawable.icon_shopping,
                R.drawable.icon_ticket,
                R.drawable.icon_personal};
        String[] names = new String[]{"我的课程", "购物车", "优惠券", "个人信息"};

        for (int i = 0; i < 4; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("icon", icons[i]);
            item.put("name", names[i]);

            listItems.add(item);
        }
    }

    private void initAdapter() {
        adapter = new SimpleAdapter(
                getActivity(),
                listItems,
                R.layout.list_item,
                new String[]{"icon", "name"},
                new int[]{R.id.image_icon, R.id.text_name});
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_image:
                shake(user_image);
                break;
        }
    }
}
