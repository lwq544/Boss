package com.lwq.boss.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.lwq.boss.MainActivity;
import com.lwq.boss.R;
import com.lwq.boss.entity.MyUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2018/11/3.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    //注册按钮
    private EditText et_name;
    private EditText et_password;
    private Button btnLogin;
    private CheckBox keep_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView() {
        et_name=(EditText)findViewById(R.id.et_name);
        et_password=(EditText)findViewById(R.id.et_password);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        keep_password=(CheckBox)findViewById(R.id.keep_password);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                //获取输入框的值
                String name=et_name.getText().toString().trim();
                String password=et_password.getText().toString().trim();
                //判断是否为空
                if (!TextUtils.isEmpty(name)&!TextUtils.isEmpty(password)){

                    //登录
                    final MyUser user=new MyUser();
                    user.setUsername(name);
                    user.setPassword(password);
                    user.login(new SaveListener<Object>() {
                        @Override
                        public void done(Object o, BmobException e) {
                            //判断结果
                            if (e==null){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));

                                finish();
                            }else {
                                Toast.makeText(LoginActivity.this,"登录失败"+e.toString(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(LoginActivity.this,"输入框不能为空",Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }
}
