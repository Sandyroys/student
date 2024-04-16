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

//添加地址
public class AddAddressActivity extends AppCompatActivity {
    Button submit;
    EditText Username, Cosignee,Phone,addressX;
    ImageButton Back;
    private boolean isFlag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        setTitle("地址添加");

        Username =this.findViewById(R.id.username);
        Cosignee = this.findViewById(R.id.name);
        Phone =this.findViewById(R.id.phone);
        addressX = this.findViewById(R.id.address);

        submit =this.findViewById(R.id.submit);
        Back=findViewById(R.id.back);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setClass(AddAddressActivity.this,AddressSetActivity.class);
                startActivity(intent);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = Cosignee.getText().toString();
                if(!strName.isEmpty()){
                    AddressDao AddressDao = new AddressDao(AddAddressActivity.this);
                    Address address = new Address(
                            AddressDao.getMaxId()+1,
                            Username.getText().toString(),
                            Cosignee.getText().toString(),
                            Phone.getText().toString(),
                            addressX.getText().toString());
                    AddressDao.add(address);
                    ToastMsg("数据添加成功！返回查看数据");

                }
                else{
                    ToastMsg("请输入合法的地址添加");
                }
            }
        });
    }

    //  信息提示类
    public void ToastMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }
}


