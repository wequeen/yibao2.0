package com.zju.yibao;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by hmw on 2016/2/2.
 */
public class USERINFO extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView title;
    private EditText sex;
    private EditText age;
    private EditText preference;
    private Button update;
    private int choice = 0;
    boolean[] selected = new boolean[]{false,false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        initView();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        //title = (TextView) findViewById(R.id.title);
        title = (TextView) findViewById(R.id.tv_title);
        title.setText("修改个人信息");

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sex = (EditText) findViewById(R.id.edit_userinfo_sex);
        sex.setOnFocusChangeListener(listener);
        sex.setOnClickListener(editListener);
        age = (EditText) findViewById(R.id.edit_userinfo_age);
        age.setOnClickListener(editListener);
        age.setOnFocusChangeListener(listener);
        preference = (EditText) findViewById(R.id.edit_userinfo_preference);
        preference.setOnFocusChangeListener(listener);
        preference.setOnClickListener(editListener);
        update = (Button) findViewById(R.id.btn_update_userinfo);
        update.setOnClickListener(buttonListener);

    }
    EditText.OnFocusChangeListener listener = new EditText.OnFocusChangeListener(){
        @Override
        public void onFocusChange(View view, boolean b) {
            switch (view.getId()) {
                case R.id.edit_userinfo_sex:
                    if (b) {
                        chooseSex();
                    }
                    break;
                case R.id.edit_userinfo_age:
                    if(b){
                        chooseDate();
                    }
                    break;
                case R.id.edit_userinfo_preference:
                    if(b){
                        choosePreference();
                    }
                    break;
                default:
                    break;
            }
        }
    };
    EditText.OnClickListener editListener = new EditText.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.edit_userinfo_sex:
                    chooseSex();
                    break;
                case R.id.edit_userinfo_age:
                    chooseDate();
                    break;
                case R.id.edit_userinfo_preference:
                    choosePreference();
                    break;
                default:
                    break;
            }
        }
    };
    Button.OnClickListener buttonListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_update_userinfo:
//                    Intent intent2 = new Intent(USERINFO.this, REGISTER3.class);
//                    startActivity(intent2);
                    break;
                default:
                    break;
            }
        }
    };

    public void chooseSex(){
        final String[] sexList={"男", "女"};
        new AlertDialog.Builder(USERINFO.this).setTitle("选择性别").setIcon(
                android.R.drawable.btn_radio).setSingleChoiceItems(
                sexList, 0,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        choice = which;
                    }
                }).setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (choice != -1) {
                    sex.setText(sexList[choice]);
                }


            }
        }).show();
    }
    public void choosePreference(){
        Dialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("多选列表对话框");
        builder.setIcon(android.R.drawable.btn_star);
        DialogInterface.OnMultiChoiceClickListener mutiListener =
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int which, boolean isChecked) {
                        selected[which] = isChecked;
                    }
                };
        builder.setMultiChoiceItems(R.array.preferenceList, selected, mutiListener);
        DialogInterface.OnClickListener btnListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String selectedStr = "";
                for(int i=0; i<selected.length; i++) {
                    if(selected[i] == true) {
                        selectedStr = selectedStr + " " +
                                getResources().getStringArray(R.array.preferenceList)[i];
                    }
                }
                preference.setText(selectedStr);
            }
        };
        builder.setPositiveButton("确定", btnListener);
        dialog = builder.create();
        dialog.show();
    }
    public void chooseDate(){
        Dialog dialog = null;
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker,int year, int month, int dayOfMonth) {
                //Calendar月份是从0开始,所以month要加1
                age.setText("" + year + "年" +
                        (month+1) + "月" + dayOfMonth + "日");
            }
        };
        dialog = new DatePickerDialog(this,
                dateListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();

    }

}
