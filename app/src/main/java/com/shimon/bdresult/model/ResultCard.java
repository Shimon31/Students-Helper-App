package com.shimon.bdresult.model;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class ResultCard {
    Drawable imageView;
    int color;
    String title;
    String siteLink;

    public ResultCard() {
    }

    public ResultCard(Drawable imageView, int color, String title, String siteLink) {
        this.imageView = imageView;
        this.color = color;
        this.title = title;
        this.siteLink = siteLink;
    }

    public Drawable getImageView() {
        return imageView;
    }

    public void setImageView(Drawable imageView) {
        this.imageView = imageView;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }
}
