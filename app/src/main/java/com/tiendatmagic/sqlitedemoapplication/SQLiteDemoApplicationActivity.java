package com.tiendatmagic.sqlitedemoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SQLiteDemoApplicationActivity extends AppCompatActivity {

    TextView datalist;
    EditText studentid;
    EditText studentname;
    EditText studentnamea;
    EditText studentnameb;
    EditText studentnamec;
    EditText studentnamed;
    EditText studentnamee;
    EditText studentnamef;
    EditText studentnameg;
    EditText studentnameh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo_application);

        datalist = (TextView) findViewById(R.id.txtData);
        studentid = (EditText) findViewById(R.id.phongbanid);
        studentname = (EditText) findViewById(R.id.phongbanname);
        studentnamea = (EditText) findViewById(R.id.phongbannamea);
        studentnameb = (EditText) findViewById(R.id.phongbannameb);
        studentnamec = (EditText) findViewById(R.id.phongbannamec);
        studentnamed = (EditText) findViewById(R.id.phongbannamed);
        studentnamee = (EditText) findViewById(R.id.phongbannamee);
        studentnamef = (EditText) findViewById(R.id.phongbannamef);
        studentnameg = (EditText) findViewById(R.id.phongbannameg);
        studentnameh = (EditText) findViewById(R.id.phongbannameh);
    }

    public void addPhongban(View view) {
        //khởi tạo đối tượng xử lý dữ liệu
        DataHandler dbHandler = new DataHandler(this,null, null,null, null, null, null, null,
                null, null,null,1);
        //nhận id
        int id = Integer.parseInt(studentid.getText().toString());
        //nhận name
        String name = studentname.getText().toString();
        String namea = studentnamea.getText().toString();
        String nameb = studentnameb.getText().toString();
        String namec = studentnamec.getText().toString();
        String named = studentnamed.getText().toString();
        String namee = studentnamee.getText().toString();
        String namef = studentnamef.getText().toString();
        String nameg = studentnameg.getText().toString();
        String nameh = studentnameh.getText().toString();
        //gán id và name đến đối tượng Phongban
        Phongban student = new Phongban(id, name, namea,nameb,namec,named,namee,namef,nameg,nameh);
        //thêm đối tượng Phongban đến bảng dữ liệu
        dbHandler.addDataHandler(student);
        //xóa sạch các PlainText
        studentid.setText("");
        studentname.setText("");
    }

    public void loadPhongbans(View view) {
        //khởi tạo đối tượng xử lý dữ liệu
        DataHandler dbHandler = new DataHandler(this,null, null,null, null, null, null, null,
                null, null,null,1);
        //hiển thị dữ liệu
        datalist.setText(dbHandler.loadDataHandler());
        //xóa sạch các PlainText
        studentid.setText("");
        studentname.setText("");
    }

    public void deletePhongban(View view) {
        DataHandler dbHandler = new DataHandler(this,null, null,null, null, null, null, null,
                null, null,null,1);
        boolean result = dbHandler.deleteDataHandler(Integer.parseInt(
                studentid.getText().toString()));
        if (result) {
            studentid.setText("");
            studentname.setText("");
            datalist.setText("Phongban Deleted");
        } else
            studentid.setText("No Match Found");
    }

    public void updatePhongban(View view) {
        DataHandler dbHandler = new DataHandler(this,null, null,null, null, null, null, null,
                null, null,null,1);
        boolean result = dbHandler.updateDataHandler(Integer.parseInt(
                studentid.getText().toString()), studentname.getText().toString(), studentnamea.getText().toString(), studentnameb.getText().toString(),
                studentnamec.getText().toString(),studentnamed.getText().toString(),studentnamee.getText().toString(),studentnamef.getText().toString(),
                studentnameg.getText().toString(),studentnameh.getText().toString());
        if (result) {
            studentid.setText("");
            studentname.setText("");
            datalist.setText("Phongban Updated");
        } else
            studentid.setText("No Match Found");
    }

    public void findFirstPhongban(View view) {
        DataHandler dbHandler = new DataHandler(this,null, null,null, null, null, null, null,
                null, null,null,1);
        Phongban student =
                dbHandler.findFisrtDataHandler
                        (studentname.getText().toString());
        if (student != null) {
            datalist.setText(String.valueOf(student.getPhongbanID())
                    + " " + student.getPhongbanName()
                    + " " + student.getPhongbanNamea()
                    + " " + student.getPhongbanNameb()
                    + " " + student.getPhongbanNamec()
                    + " " + student.getPhongbanNamed()
                    + " " + student.getPhongbanNamee()
                    + " " + student.getPhongbanNamef()
                    + " " + student.getPhongbanNameg()
                    + " " + student.getPhongbanNameh()
                    + System.getProperty("line.separator"));
            studentid.setText("");
            studentname.setText("");
        } else {
            datalist.setText("No Match Found");
            studentid.setText("");
            studentname.setText("");
        }
    }

    public void findAllPhongban(View view) {
        DataHandler dbHandler = new DataHandler(this,null, null,null, null, null, null, null,
                null, null,null,1);
        List<Phongban> lst =
                dbHandler.findAllDataHandler
                        (studentname.getText().toString());
        String studentsList = "";
        if (!lst.isEmpty()) {
            for(Phongban st:lst)
            {
                studentsList += String.valueOf(st.getPhongbanID())
                        + " " + st.getPhongbanName()
                        + " " + st.getPhongbanNamea()
                        + " " + st.getPhongbanNameb()
                        + " " + st.getPhongbanNamec()
                        + " " + st.getPhongbanNamed()
                        + " " + st.getPhongbanNamee()
                        + " " + st.getPhongbanNamef()
                        + " " + st.getPhongbanNameg()
                        + " " + st.getPhongbanNameh()
                        + System.getProperty("line.separator");
                studentid.setText("");
                studentname.setText("");
            }
            datalist.setText(studentsList);
        } else {
            datalist.setText("No Match Found");
            studentid.setText("");
            studentname.setText("");
        }
    }

}


