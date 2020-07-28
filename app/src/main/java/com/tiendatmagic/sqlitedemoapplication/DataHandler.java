package com.tiendatmagic.sqlitedemoapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataHandler extends SQLiteOpenHelper {

    // các biến mô tả cơ sở dữ liệu
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Tiendatmagic.db";
    public static final String TABLE_NAME = "Phongbans";
    public static final String COLUMN_ID = "PhongbanID";
    public static final String COLUMN_NAME = "PhongbanName";
    public static final String COLUMN_NAMEA = "PhongbanNamea";
    public static final String COLUMN_NAMEB = "PhongbanNameb";
    public static final String COLUMN_NAMEC = "PhongbanNamec";
    public static final String COLUMN_NAMED = "PhongbanNamed";
    public static final String COLUMN_NAMEE = "PhongbanNamee";
    public static final String COLUMN_NAMEF = "PhongbanNamef";
    public static final String COLUMN_NAMEG = "PhongbanNameg";
    public static final String COLUMN_NAMEH = "PhongbanNameh";
    public static final String COLUMN_NAMEHH = "PhongbanNamehh";
    //phương thức khởi tạo
    public DataHandler(Context context, String name, String namea, String nameb, String namec, String named, String namee,
                       String namef,String nameg,String nameh,String namehh,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    // Các bạn có thấy mình đẹp trai không
    @Override
    public void onCreate(SQLiteDatabase db) {

        //chuỗi lệnh truy vấn tạo bảng Phongbans
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT,"+ COLUMN_NAMEA + " TEXT,"+COLUMN_NAMEB +" TEXT,"+COLUMN_NAMEC+" TEXT,"+COLUMN_NAMED+" TEXT,"+
                COLUMN_NAMEE+" TEXT,"+COLUMN_NAMEF+" TEXT,"+COLUMN_NAMEG+" TEXT,"+COLUMN_NAMEH+" TEXT,"+COLUMN_NAMEHH+" TEXT)";

        //thực thi truy vấn
        db.execSQL(CREATE_STUDENTS_TABLE);
    }
    //© 2020 Copyright by Tiendatmagic
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        //Xóa bảng nếu tồn tại
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //Tạo bảng mới
        onCreate(db);
    }
    // Các bạn có thấy mình đẹp trai không
    public String loadDataHandler() {
        String result = "";
        //chuỗi truy vấn SELECT
        String query = "SELECT* FROM " + TABLE_NAME;
        //sẵn sàng thực thi các truy vấn
        SQLiteDatabase db = this.getWritableDatabase();
        //thực thi truy vấn bằng phương thức rawQuery()
        //kết quả trả về lưu trong đối tượng Cursor
        Cursor cursor = db.rawQuery(query, null);
        //duyệt qua dữ liệu từ đối tượng Cursor
        while (cursor.moveToNext()) {
            //nhận giá trị cột thứ nhất (PhongbanID)
            int result_0 = cursor.getInt(0);
            //nhận giá trị cột thứ hai (PhongbanName)
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            String result_3 = cursor.getString(3);
            String result_4 = cursor.getString(4);
            String result_5 = cursor.getString(5);
            String result_6 = cursor.getString(6);
            String result_7 = cursor.getString(7);
            String result_8 = cursor.getString(8);
            String result_9 = cursor.getString(9);
            String result_10 = cursor.getString(10);
            //hiển thị mỗi hàng trong một chuỗi
            result += String.valueOf(result_0) + " " + result_1  + " " + result_2 + " " + result_3 + " " + result_4 + " " + result_5
                    + " " + result_6 + " " + result_7 + " " + result_8 + " " + result_9 + " " + result_10 +
                    System.getProperty("line.separator");
        }
        //đóng đối tượng Cursor
        cursor.close();
        //đóng đối tượng SQLiteDatabase
        db.close();
        return result;
    }
    //© 2020 Copyright by Tiendatmagic
    //thêm dữ liệu đến bảng Phongbans
    public void addDataHandler(Phongban student) {
        //tạo đối tượng ContentValues
        ContentValues values = new ContentValues();
        //thêm giá trị các cột đến đối tượng ContentValues
        values.put(COLUMN_ID, student.getPhongbanID());
        values.put(COLUMN_NAME, student.getPhongbanName());
        values.put(COLUMN_NAMEA, student.getPhongbanNamea());
        values.put(COLUMN_NAMEB, student.getPhongbanNameb());
        values.put(COLUMN_NAMEC, student.getPhongbanNamec());
        values.put(COLUMN_NAMED, student.getPhongbanNamed());
        values.put(COLUMN_NAMEE, student.getPhongbanNamee());
        values.put(COLUMN_NAMEF, student.getPhongbanNamef());
        values.put(COLUMN_NAMEG, student.getPhongbanNameg());
        values.put(COLUMN_NAMEH, student.getPhongbanNameh());
        values.put(COLUMN_NAMEHH, student.getPhongbanNamehh());
        SQLiteDatabase db = this.getWritableDatabase();
        //chèn dữ liệu đến bảng
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    //© 2020 Copyright by Tiendatmagic
    public boolean deleteDataHandler(int ID) {
        boolean result = false;
        String query = "Select * FROM "
                + TABLE_NAME + " WHERE "
                + COLUMN_ID + " = '"
                + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Phongban student = new Phongban();
        if (cursor.moveToFirst()) {
            student.setPhongbanID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN_ID + "=?",
                    new String[] {
                            String.valueOf(student.getPhongbanID())
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
    //© 2020 Copyright by Tiendatmagic
    public boolean updateDataHandler(int ID, String name, String namea, String nameb, String namec, String named, String namee,
                                     String namef,String nameg,String nameh,String namehh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        args.put(COLUMN_NAMEA, namea);
        args.put(COLUMN_NAMEB, nameb);
        args.put(COLUMN_NAMEC, namec);
        args.put(COLUMN_NAMED, named);
        args.put(COLUMN_NAMEE, namee);
        args.put(COLUMN_NAMEF, namef);
        args.put(COLUMN_NAMEG, nameg);
        args.put(COLUMN_NAMEH, nameh);
        args.put(COLUMN_NAMEHH, namehh);
        return db.update(TABLE_NAME, args, COLUMN_ID + " = " + ID, null) > 0;
    }

    //tìm kiếm Phongban theo PhongbanName
//kết quả trả về là Phongban đầu tiên trong danh sách kết quả
    public Phongban findFisrtDataHandler(String studentname) {

        //chuỗi truy vấn tìm kiếm Phongban theo PhongbanName
        String query = "Select * FROM " + TABLE_NAME
                + " WHERE " + COLUMN_NAME + " = "
                + "'" + studentname + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        // Thực thi truy vấn và gán kết quả đến đối tượng Cursor
        Cursor cursor = db.rawQuery(query, null);
        Phongban student = new Phongban();
        //trả về hàng đầu tiên trong kết quả
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            student.setPhongbanID(Integer.parseInt(cursor.getString(0)));
            student.setPhongbanName(cursor.getString(1));
            student.setPhongbanNamea(cursor.getString(2));
            student.setPhongbanNameb(cursor.getString(3));
            student.setPhongbanNamec(cursor.getString(4));
            student.setPhongbanNamed(cursor.getString(5));
            student.setPhongbanNamee(cursor.getString(6));
            student.setPhongbanNamef(cursor.getString(7));
            student.setPhongbanNameg(cursor.getString(8));
            student.setPhongbanNameh(cursor.getString(9));
            student.setPhongbanNamehh(cursor.getString(10));
            cursor.close();
        } else {
            student = null;
        }
        db.close();
        //trả về sinh viên đầu tiên tìm được
        return student;
    }

    //tìm kiếm Phongban theo PhongbanName
//kết quả trả về là tất cả Phongban trong danh sách kết quả
    public List<Phongban> findAllDataHandler(String studentname) {
        //chuỗi truy vấn tìm kiếm Phongban theo PhongbanName
        String query = "Select * FROM " + TABLE_NAME
                + " WHERE " + COLUMN_NAME + " = "
                + "'" + studentname + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        //danh sách chứa tất cả các Phongban tìm được
        List<Phongban> lst =  new ArrayList<Phongban>();
        // Thực thi truy vấn và gán kết quả đến đối tượng Cursor
        Cursor cursor = db.rawQuery(query, null);
        //duyệt qua tất cả các hàng từ hàng đầu tiên
        if(cursor.moveToFirst()) {
            do {
                Phongban student = new Phongban();
                student.setPhongbanID
                        (Integer.parseInt(cursor.getString(0)));
                student.setPhongbanName(cursor.getString(1));
                student.setPhongbanNamea(cursor.getString(2));
                student.setPhongbanNameb(cursor.getString(3));
                student.setPhongbanNamec(cursor.getString(4));
                student.setPhongbanNamed(cursor.getString(5));
                student.setPhongbanNamee(cursor.getString(6));
                student.setPhongbanNamef(cursor.getString(7));
                student.setPhongbanNameg(cursor.getString(8));
                student.setPhongbanNameh(cursor.getString(9));
                student.setPhongbanNamehh(cursor.getString(10));
                lst.add(student);
            }while (cursor.moveToNext());
        }
        //đóng các đối tượng
        cursor.close();
        db.close();
        //trả về danh sách sinh viên tìm được
        return lst;
    }
//© 2020 Copyright by Tiendatmagic


}