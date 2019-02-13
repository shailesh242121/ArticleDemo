package com.articaldemo.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *  Co-Helper class for media
 */
public class MediaMetadata implements Parcelable {

    protected MediaMetadata(Parcel in) {
        url = in.readString();
        format = in.readString();
        height = in.readLong();
        width = in.readLong();
    }

    public static final Creator<MediaMetadata> CREATOR = new Creator<MediaMetadata>() {
        @Override
        public MediaMetadata createFromParcel(Parcel in) {
            return new MediaMetadata(in);
        }

        @Override
        public MediaMetadata[] newArray(int size) {
            return new MediaMetadata[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    private String url;
    private String format;
    private long height;
    private long width;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(format);
        dest.writeLong(height);
        dest.writeLong(width);
    }
}
