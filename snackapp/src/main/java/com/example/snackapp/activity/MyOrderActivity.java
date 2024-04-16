package com.example.snackapp.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snackapp.MyApplication;
import com.example.snackapp.R;
import com.example.snackapp.adaptor.OrderAdapter;
import com.example.snackapp.dao.OrderDao;
import com.example.snackapp.model.Order;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//点击我的订单界面
public class MyOrderActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.show_orders)
    RecyclerView show_orders;
    Button button;
    TextView orderName;
    EditText query;
    Button check;
    String query1;
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MyOrderActivity.class);
        context.startActivity(intent);
    }

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("订单");
        query = findViewById(R.id.query);
        check = findViewById(R.id.check);
        show_orders = findViewById(R.id.show_orders);
        show_orders.setLayoutManager(new LinearLayoutManager(MyOrderActivity.this));

       // initAdapter();
        ShowOrders();
       ButterKnife.bind(this);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query1 = String.valueOf(query.getText());
                Log.i("zut",query1);
                query(query1);
            }
        });

    }


    //我的订单 根据菜名进行查询
    private void query(String name){
       List<Order> orders_name = OrderDao.findAllByName(name);
     OrderAdapter orderAdapter =new OrderAdapter(orders_name);
        show_orders.setAdapter(orderAdapter);
    }

    //把订单罗列出来
    private void ShowOrders(){
        String  uesrname = MyApplication.getUser().getUsername();
        List<Order> orders_user =OrderDao.findAllByUsername(uesrname);
      OrderAdapter orderAdapter =new OrderAdapter(orders_user);
        show_orders.setAdapter(orderAdapter);

    }



}