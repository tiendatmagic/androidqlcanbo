package com.tiendatmagic.sqlitedemoapplication;

public class Phongban {
    //các biến tương ứng với các cột của bảng Phongbans
    private int _studentid;
    private String _studentname;
    private String _studentnamea;
    private String _studentnameb;
    private String _studentnamec;
    private String _studentnamed;
    private String _studentnamee;
    //Các phương thức khởi tạo (constructors)
    //Phương thức khởi tạo mặc định
    public Phongban(){

    }
    //Phương thức khởi tạo có tham số
    public Phongban(int id, String name, String namea, String nameb, String namec, String named, String namee){
        this._studentid = id;
        this._studentname = name;
        this._studentnamea = namea;
        this._studentnameb = nameb;
        this._studentnamec = namec;
        this._studentnamed = named;
        this._studentnamee = namee;
    }

    //các phương thức truy cập các biến thành viên

    public int getPhongbanID(){
        return this._studentid;
    }
    public void setPhongbanID(int id){
        this._studentid = id;
    }

    public String getPhongbanName(){
        return this._studentname;
    }
    public void setPhongbanName(String name){
        this._studentname = name;
    }

    public String getPhongbanNamea(){
        return this._studentnamea;
    }
    public void setPhongbanNamea(String namea){
        this._studentnamea = namea;
    }

    public String getPhongbanNameb(){
        return this._studentnameb;
    }
    public void setPhongbanNameb(String nameb){ this._studentnameb = nameb; }

    public String getPhongbanNamec(){
        return this._studentnamec;
    }
    public void setPhongbanNamec(String namec){
        this._studentnamec = namec;
    }

    public String getPhongbanNamed(){
        return this._studentnamed;
    }
    public void setPhongbanNamed(String named){
        this._studentnamed = named;
    }

    public String getPhongbanNamee(){
        return this._studentnamee;
    }
    public void setPhongbanNamee(String namee){
        this._studentnamee = namee;
    }

}