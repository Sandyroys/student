package com.example.snackapp.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snackapp.R;
import com.example.snackapp.dao.AddressDao;
import com.example.snackapp.model.Address;

import java.util.List;

//地址管理界面
public class AddressSetActivity extends AppCompatActivity {

    public static final String FLAG="id";
    ListView show_address;
    String strType;
    Button addAddress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_set);
        show_address=findViewById(R.id.show_address);

        ShowAddress();
        addAddress=findViewById(R.id.addAddress);
        setTitle("地址管理");

        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setClass(AddressSetActivity.this,AddAddressActivity.class);
                startActivity(intent);
            }
        });

        show_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strInfo=String.valueOf(((TextView)view).getText());
                String strId = strInfo.substring(0, strInfo.indexOf('|'));
                Intent intent = new Intent(AddressSetActivity.this,
                        DeleteAddressActivity.class);
                intent.putExtra(FLAG,new String[]{strId,strType});
                startActivity(intent);

            }
        });


    }
//把地址罗列出来
    private void ShowAddress(){
        String[] strinfos =null;
        strType = "btnininfo";
        ArrayAdapter<String> arrayAdapter = null;
        AddressDao addressDao =new AddressDao(this);
        List<Address> listInfos = addressDao.getScrollData(0,(int)addressDao.getCount());
        strinfos = new String[listInfos.size()];
        int m=0;
        for(com.example.snackapp.model.Address address:listInfos){
            strinfos[m] = address.getId()+"|"+"收货人:"+address.getCosignee()+"\n"+"电话:"+address.getPhone()+"\n地址："+address.getAddress()+"\n"+"点击可删除或修改";
            m++;
        }
        arrayAdapter = new ArrayAdapter<String>(AddressSetActivity.this,
                android.R.layout.simple_list_item_1,strinfos);
        show_address.setAdapter(arrayAdapter);
    }
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AddressSetActivity.class);
        context.startActivity(intent);
    }

}