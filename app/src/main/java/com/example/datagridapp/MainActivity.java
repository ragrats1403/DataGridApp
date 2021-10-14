package com.example.datagridapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnadd, btndelete, btnupdate;
    private String fname,lname,mname,fullname,itemselected;
    private EditText fn,ln,mn;
    private ListView lv;

    ArrayList<String> namelist;
    ArrayAdapter<String> namelistAdapter;
    private long itemid;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btnadd = findViewById(R.id.btnAdd);
         btndelete = findViewById(R.id.btnDelete);
         btnupdate = findViewById(R.id.btnUpdate);
         fn = findViewById(R.id.fn);
         ln = findViewById(R.id.ln);
         mn = findViewById(R.id.mn);
         lv = findViewById(R.id.list);
         btnadd.setText("Add");
         btndelete.setText("Delete");
         btnupdate.setText("Update");
         populateview();



         btnadd.setOnClickListener(this);
        //btndelete.setOnClickListener(this);

         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 itemselected = adapterView.getItemAtPosition(i).toString();
                 fname = fn.getText().toString();
                 lname = ln.getText().toString();
                 mname = mn.getText().toString();
                 fullname = fname +" "+ mname+ " " + lname;

                 btndelete.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         namelist.remove(itemselected);
                         namelistAdapter.notifyDataSetChanged();
                     }
                 });
                 btnupdate.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         namelist.set(i, fullname);
                         namelistAdapter.notifyDataSetChanged();
                     }
                 });
             }
         });


    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {

            case R.id.btnAdd:
            {
                fname = fn.getText().toString();
                lname = ln.getText().toString();
                mname = mn.getText().toString();
                fullname = fname +" "+ mname+ " " + lname;
                namelist.add(fullname);
                namelistAdapter.notifyDataSetChanged();
            }
            break;



        }
    }




    public void populateview()
    {
        namelist = new ArrayList<>();
        namelistAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, namelist);
        lv.setAdapter(namelistAdapter);
    }

}