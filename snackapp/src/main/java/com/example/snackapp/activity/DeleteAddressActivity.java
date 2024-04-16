package com.example.snackapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snackapp.R;
import com.example.snackapp.dao.AddressDao;
import com.example.snackapp.model.Address;

//删除或修改地址
public class DeleteAddressActivity extends AppCompatActivity {

    Button Delete;
    Button alter;

    ImageButton Back;
    EditText Username, Cosignee,Phone,addressX;

    String[] strInfos;
    String strId;
    String strType;
    com.example.snackapp.dao.AddressDao AddressDao;   // 创建操作对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_address);
        setTitle("删除或修改地址");

        AddressDao = new AddressDao(this);
        alter = this.findViewById(R.id.alter);
        Username =this.findViewById(R.id.username);
        Cosignee = this.findViewById(R.id.name);
        Phone =this.findViewById(R.id.phone);
        addressX = this.findViewById(R.id.address);

        Delete =this.findViewById(R.id.submit);
        Back=findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setClass(DeleteAddressActivity.this,AddressSetActivity.class);
                startActivity(intent);
            }
        });

        //获取intent 对象
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        strInfos = bundle.getStringArray(AddressSetActivity.FLAG);
        //获得ID
        strId   = strInfos[0];
        //获得类型
        strType = strInfos[1];
        //将数据显示出来
        if(strType.equals("btnininfo")){
            Address address = AddressDao.find(Integer.parseInt(strId));
            Username.setText(address.getUsername());
            Cosignee.setText(address.getCosignee());
            Phone.setText(address.getPhone());
            addressX.setText(address.getAddress());
        }
        //删除按钮的点击事件
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strType.equals("btnininfo")){
                    AddressDao.deleteId(Integer.parseInt(strId));
                    ToastMsg("删除成功，返回查看吧");
                }
            }
        });
        //修改按钮的点击事件
        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strType.equals("btnininfo")){
                     AddressDao.deleteId(Integer.parseInt(strId));

                    String strName = Cosignee.getText().toString();
                    if(!strName.isEmpty()){
                        com.example.snackapp.dao.AddressDao AddressDao = new AddressDao(DeleteAddressActivity.this);
                        Address address = new Address(
                                AddressDao.getMaxId(),
                                Username.getText().toString(),
                                Cosignee.getText().toString(),
                                Phone.getText().toString(),
                                addressX.getText().toString());
                        AddressDao.add(address);
                           ToastMsg("数据修改成功！返回查看数据");
                    }
                    else{

                        Toast.makeText(DeleteAddressActivity.this, "请输入正确的地址进行修改", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    // 信息提示类
    public void ToastMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}