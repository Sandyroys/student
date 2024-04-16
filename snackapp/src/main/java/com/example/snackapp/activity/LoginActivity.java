package com.example.snackapp.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snackapp.MainActivity;
import com.example.snackapp.MyApplication;
import com.example.snackapp.R;

import com.example.snackapp.dao.UserDao;
import com.example.snackapp.model.User;
import com.example.snackapp.utils.Tips;

import butterknife.BindView;
import com.example.snackapp.dao.DbContect;
//登录界面

public class LoginActivity extends AppCompatActivity {
    private EditText edt_Username, edt_PassWord,edt_Random;
    private Button btn_Login, btn_Forget, btn_Register;
    boolean isFlag = false;

    DbContect dbContect;

    @BindView(R.id.edt_UserName)
    EditText usernameEdit;


    //在活动中向外提供启动该活动的方法
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // myDataBaseHelper = new DatabaseHelper(this);
        dbContect = new DbContect(this);
        edt_Username = this.findViewById(R.id.edt_UserName);
        edt_PassWord = this.findViewById(R.id.edt_Password);
        btn_Login = this.findViewById(R.id.btn_Login);
        btn_Forget = this.findViewById(R.id.btn_Forget);
        btn_Register = this.findViewById(R.id.btn_Register);

        //打开数据库
        SQLiteDatabase database = dbContect.getWritableDatabase();

        //登录事件监听
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                isFlag = false;
                String username = edt_Username.getText().toString();
                String password = edt_PassWord.getText().toString();
                //判断输入是否为空，若为空，给出提示
                if (username.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "请输入账号或密码！", Toast.LENGTH_SHORT).show();
                    isFlag = true;
                }
                //查询账号密码，若数据库表为空，提示用户注册

                Cursor cursor = database.query("user", new String[]{"username,password"}, null, null, null, null, null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(LoginActivity.this, "请先注册账号！", Toast.LENGTH_SHORT).show();
                    isFlag=true;
                }
                //若数据库表不为空，查看用户输入的账号密码是否与数据库表中的相匹配，若匹配，登录成功，跳转到主界面
                // 否则无法登录，给出账号密码错误提示
                else {
                    //cursor默认是行的集合 moveToNext（）是用来遍历数据库
                    while (cursor.moveToNext()){

                        if (username.equals(cursor.getString(cursor.getColumnIndex("username"))) && password.equals(cursor.getString(cursor.getColumnIndex("password")))) {

                            User user = new User(username, password);
                            Tips.show("登录成功");
                            MyApplication.isLogin(true);
                            MyApplication.setUser(user);
                            // 持久化已登录用户数据
                            UserDao.saveUser(user);
                            UserDao.ifLogin(true);
                            // 持久化账号，以便退出登录后不用再输入账号
                            UserDao.saveUsername(username);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            isFlag = true;
                            break;
                        }
                    }
                    if (isFlag == false) {
                        Toast.makeText(LoginActivity.this, "账号或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //修改密码监听事件，点击忘记密码，跳转到修改密码界面
        btn_Forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Forget_Password.class);
               startActivity(intent);
            }
        });
        //注册监听事件，点击新用户，跳转到注册界面
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

}
