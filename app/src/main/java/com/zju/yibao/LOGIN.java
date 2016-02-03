package com.zju.yibao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LOGIN extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tv_title;
    private Button btnLogin;
    private  Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("登录");

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(listener);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(listener);

    }

    Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_login:
                    Intent intent1 = new Intent(LOGIN.this, LOGIN.class);
                    startActivity(intent1);
                    break;
                case R.id.btn_register:
                    Intent intent2 = new Intent(LOGIN.this, REGISTER1.class);
                    startActivity(intent2);
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
