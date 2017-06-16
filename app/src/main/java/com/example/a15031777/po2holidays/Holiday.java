package com.example.a15031777.po2holidays;

import android.widget.ImageView;

/**
 * Created by 15031777 on 27/4/2017.
 */

public class Holiday {
    private String title;
    private String date;
    private String image;
    public Holiday(String title, String date, String image) {
        this.title = title;
        this.date = date;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }
    public String getImage() { return image; }
}

