package com.zju.yibao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Atlas on 15/12/16.
 */
public class MyFragment2 extends android.app.Fragment implements View.OnClickListener {

    private View root;
    private CircleImageView user_image;

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
    }

    private void initView() {
        user_image = (CircleImageView) root.findViewById(R.id.user_image);
        user_image.setOnClickListener(this);
    }

    private void shake(View view) {
        final TranslateAnimation anim = new TranslateAnimation(0, 10, 0, 0);
        anim.setInterpolator(new CycleInterpolator(2f));
        anim.setDuration(300);
        view.startAnimation(anim);
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
