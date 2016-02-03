package com.zju.yibao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hmw on 2016/2/2.
 */
public class REGISTER3 extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView title;
    private Button registerEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        initView();
    }
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        //title = (TextView) findViewById(R.id.title);
        title = (TextView) findViewById(R.id.tv_title);
        title.setText("注册");

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        registerEnd = (Button) findViewById(R.id.btn_registerEnd);
        registerEnd.setOnClickListener(listener);


    }

    Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_registerEnd:
                    Intent intent1 = new Intent(REGISTER3.this, USERINFO.class);
                    startActivity(intent1);
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
