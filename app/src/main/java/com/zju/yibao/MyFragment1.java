package com.zju.yibao;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Atlas on 15/12/16.
 */

public class MyFragment1 extends android.app.Fragment {

    private View root;

    private ConvenientBanner convenientBanner;
    private ArrayList<Integer> localImages = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_show_1, null);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        editBanner();
    }

    private void initView() {
        convenientBanner = (ConvenientBanner) root.findViewById(R.id.convenientBanner);
    }

    private void editBanner() {

        initImageLocal();
        CBViewHolderCreator<LocalImageHolderView> cbViewHolderCreator1 = new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        };

        convenientBanner.setPages(cbViewHolderCreator1, localImages);
        convenientBanner
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        try {
            convenientBanner.getViewPager().setPageTransformer(true, CubeOutTransformer.class.newInstance());
        } catch (Exception e) {
        }
    }

    private void initImageLocal() {
        if (localImages.size() != 0) {
            return;
        }
        for (int position = 0; position < 6; position++) {
            localImages.add(getResId("ic_test_" + position, R.drawable.class));
        }
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
