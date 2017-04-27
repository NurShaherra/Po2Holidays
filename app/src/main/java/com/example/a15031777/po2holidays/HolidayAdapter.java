package com.example.a15031777.po2holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15031777 on 27/4/2017.
 */

public class HolidayAdapter extends ArrayAdapter<Holidays> {

    private ArrayList<Holidays> holidays;
    private Context context;
    private TextView tvTitle;
    private TextView tvDate;
    private ImageView image;

    public HolidayAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        image = (ImageView) rowView.findViewById(R.id.image);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holidays currentHol = holidays.get(position);
        // Set the TextView to show the food

        tvTitle.setText(currentHol.getHols());
        // Set the image to star or nostar accordingly
        if(currentHol.getHols()) {
            image.setImageResource(R.drawable.newyear);
            tvDate.setText("1 Jan 2017");
        }
        else {
            image.setImageResource(R.drawable.labour);
            tvDate.setText("1 May 2017");
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}

}
