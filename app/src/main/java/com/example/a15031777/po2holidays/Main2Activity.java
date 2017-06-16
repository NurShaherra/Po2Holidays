package com.example.a15031777.po2holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv = (TextView) findViewById(R.id.title);
        ListView lv = (ListView) findViewById(R.id.lvTypes);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tv.setText(type);

        if (type.equalsIgnoreCase("secular")) {
            holiday.add(new Holiday("New Year", "1 Jan 2017", "newyear"));
            holiday.add(new Holiday("Labour Day", "1 May 2017", "labour"));
        } else {
            holiday.add(new Holiday("Hari Raya", "26 June 2017", "cny"));
            holiday.add(new Holiday("Good Friday", "13 November 2017", "goodfriday"));


        }
        aa = new HolidayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHol = holiday.get(position);

                Toast.makeText(Main2Activity.this, selectedHol.getTitle()
                                + " Date: " + selectedHol.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
