package com.zju.yibao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RadioGroup;

public class HOME extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Toolbar toolbar;
    private RadioGroup radioGroup;
    private MyFragment1 myFragment1;
    private MyFragment2 myFragment2;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initActionbar();
        showFragment1();

        preferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = preferences.edit();
        isLogin = preferences.getBoolean("isLogin", false);

        /**
         * 手动控制isLogin的值
         * */

        isLogin = false;
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        radioGroup = (RadioGroup) findViewById(R.id.bottom_bar);
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void initActionbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.bottom_bar_1:
                showFragment1();
                break;
            case R.id.bottom_bar_2:
                if (isLogin) {
                    showFragment2();
                } else {
                    Intent intent = new Intent(HOME.this, LOGIN.class);
                    startActivity(intent);
                }
                break;
        }
    }

    private void showFragment1() {
        if (myFragment1 == null) {
            myFragment1 = new MyFragment1();
        }
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_show, myFragment1)
                .commit();
    }

    private void showFragment2() {
        if (myFragment2 == null) {
            myFragment2 = new MyFragment2();
        }
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_show, myFragment2)
                .commit();
    }
}
