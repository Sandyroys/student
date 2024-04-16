package com.example.snackapp.ui.my;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.snackapp.MyApplication;
import com.example.snackapp.R;
import com.example.snackapp.activity.AddressSetActivity;
import com.example.snackapp.activity.LoginActivity;
import com.example.snackapp.activity.MyOrderActivity;
import com.example.snackapp.activity.OrderActivity;
import com.example.snackapp.dao.UserDao;
import com.example.snackapp.model.User;
import com.example.snackapp.utils.Tips;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

//我的 界面
public class MyFragment extends Fragment {
    // @BindView(R.id.**)用来寻找相应的组件id

    private MyViewModel myViewModel;

// 头像
    @BindView(R.id.myUserHead)
CircleImageView image;
// 用户名
    @BindView(R.id.myUserNickName)
    TextView nickname;
// 账号
    @BindView(R.id.myUserName)
    TextView username;
// 我的订单
    @BindView(R.id.myModifyView)
    LinearLayout modifyView;
// 待付款
    @BindView(R.id.Obligation)
    LinearLayout Obligation;
// 待评价
    @BindView(R.id.Evaluate)
    LinearLayout Evaluate;
// 退款
    @BindView(R.id.Refund)
    LinearLayout Refund;
// 设置部分
    @BindView(R.id.myGeneralView)
    LinearLayout generalView;
    // 地址管理
    @BindView(R.id.SetAddress)
    TextView SetAddress;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        //寻找然后导入相应的布局文件
        View root = inflater.inflate(R.layout.fragment_my, container, false);
        // 绑定资源
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }


// 获取当前用户名
    @SuppressLint("SetTextI18n")
    private void initView() {
        if (MyApplication.isLogin()) {
            User user = MyApplication.getUser();
           // image.setImageResource(user.getHeadImage());
            nickname.setText("用户名: " +user.getUsername());
            username.setText("账号ID: " + user.getUsername());
        }
    }

    //点击头像

    @OnClick(R.id.myUserHead)
    void clickImage() {
        if (MyApplication.isLogin()) {
            Tips.show("已登录");
        } else {
            LoginActivity.actionStart(getActivity());
        }
    }

    //点击我的订单

    @OnClick(R.id.myOrderView)
    void clickOrder() {
        if (MyApplication.isLogin()) {
            MyOrderActivity.actionStart(getContext());
        } else {
            Tips.show("请先登录");
        }
    }
    //点击待付款
    @OnClick(R.id.Obligation)
    void clickObligation() {
        if (MyApplication.isLogin()) {
            OrderActivity.actionStart(getContext());
            Toast.makeText(getContext(), "没有待付款的小吃", Toast.LENGTH_SHORT).show();
        } else {
            Tips.show("请先登录");
        }
    }
    //地址设置
    @OnClick(R.id.SetAddress)
    void clickAdressSet() {
        if (MyApplication.isLogin()) {
            AddressSetActivity.actionStart(getContext());
        } else {
            Tips.show("请先登录");
        }
    }
    //点击通用
    @OnClick(R.id.myGeneralText)
    void clickShowGeneral() {
        if (generalView.getVisibility() == View.GONE) {
            generalView.setVisibility(View.VISIBLE);
        } else {
            generalView.setVisibility(View.GONE);
        }
    }
    //通用设置
    @OnClick(R.id.myGeneralBtn)
    void clickGeneralSubmit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("提示")
                .setMessage("是否保存通用设置")
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        generalView.setVisibility(View.GONE);
                    }
                })
                .create()
                .show();
    }

    // 点击退出登录
    @OnClick(R.id.logoutBtn)
    void clickLogout() {
        if (MyApplication.isLogin()) {
            // 清除持久化数据
            UserDao.removeUserAndLoginStatus();
            // 清除全局数据
            MyApplication.isLogin(false);
            MyApplication.setUser(null);
            nickname.setText("未登录");
            username.setText("");
            image.setImageResource(R.mipmap.logo);
        } else {
            Tips.show("还没有登录，请先登录");
        }
    }
    public static void actionStartP(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}