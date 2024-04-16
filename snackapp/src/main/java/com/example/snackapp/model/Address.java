package com.example.snackapp.model;
//地址
public class Address {

    private int id;     //  id 主键 自增
    private String username;    // 时间
    private String cosignee;     // 收货人
    private String phone;   // 电话
    private String address;      // 地址
    public Address(){
        super();
    }
    public Address(int id,String username,String cosignee,String phone,String address){
        super();
        this.id=id;
        this.username=username;
        this.cosignee=cosignee;
        this.phone=phone;
        this.address=address;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername(){
        return  this.username;
    }
    public void setUsername(String usesrname){
        this.username=username;
    }
    public String getCosignee(){
        return this.cosignee;
    }
    public void setCosignee(String cosignee){
        this.cosignee=cosignee;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address=address;
    }
}

