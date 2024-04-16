package com.example.snackapp.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snackapp.R;
//首页界面

public class OrderActivity extends AppCompatActivity {

   // private Button submit;
/*    @BindView(R.id.orderRecyclerView)
    RecyclerView orderRecyclerView;*/
  // private EditText queryEdit;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, OrderActivity.class);
        context.startActivity(intent);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_home_image);


        setTitle("下单");

      //  orderRecyclerView.setLayoutManager(new LinearLayoutManager(OrderActivity.this));

      //  initAdapter();
      //  ButterKnife.bind(this);

    }
  /*  // 初始化订单页面
    private void initAdapter() {
        // 获取数据库数据
        List<Order> orders = OrderDao.findAllByUsername(MyApplication.getUser().getUsername());
        OrderAdapter adapter = new OrderAdapter(orders);
        // 设置空布局
        adapter.setEmptyView(getEmptyView());
        orderRecyclerView.setAdapter(adapter);
    }*/
  /*  public View getEmptyView() {
        return getLayoutInflater().inflate(R.layout.empty_order_view, orderRecyclerView, false);
    }*/

}