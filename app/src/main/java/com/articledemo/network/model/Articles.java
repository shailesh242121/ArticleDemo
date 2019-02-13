package com.articledemo.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 *  Common Article Model Class
 *  Implemented Parcelable for sending in arguments
 */
public class Articles implements Parcelable {

    private String url;
    private String adx_keywords;
    private String subsection;
    private String email_count;
    private String column;
    private String eta_id;
    private String section;
    private double id;
    private double asset_id;
    private String nytdsection;
    private String byline;
    private String type;
    private String title;
    @SerializedName("abstract")
    private String abstractType;
    private String published_date;
    private String source;

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    private List<Media> media = new ArrayList<>();

    protected Articles(Parcel in) {
        url = in.readString();
        adx_keywords = in.readString();
        subsection = in.readString();
        email_count = in.readString();
        column = in.readString();
        eta_id = in.readString();
        section = in.readString();
        id = in.readDouble();
        asset_id = in.readDouble();
        nytdsection = in.readString();
        byline = in.readString();
        type = in.readString();
        title = in.readString();
        abstractType = in.readString();
        published_date = in.readString();
        source = in.readString();

    }

    public static final Creator<Articles> CREATOR = new Creator<Articles>() {
        @Override
        public Articles createFromParcel(Parcel in) {
            return new Articles(in);
        }

        @Override
        public Articles[] newArray(int size) {
            return new Articles[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdx_keywords() {
        return adx_keywords;
    }

    public void setAdx_keywords(String adx_keywords) {
        this.adx_keywords = adx_keywords;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getEmail_count() {
        return email_count;
    }

    public void setEmail_count(String email_count) {
        this.email_count = email_count;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getEta_id() {
        return eta_id;
    }

    public void setEta_id(String eta_id) {
        this.eta_id = eta_id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(double asset_id) {
        this.asset_id = asset_id;
    }

    public String getNytdsection() {
        return nytdsection;
    }

    public void setNytdsection(String nytdsection) {
        this.nytdsection = nytdsection;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractType() {
        return abstractType;
    }

    public void setAbstractType(String abstractType) {
        this.abstractType = abstractType;
    }
//
    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }
//
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(adx_keywords);
        dest.writeString(subsection);
        dest.writeString(email_count);
        dest.writeString(column);
        dest.writeString(eta_id);
        dest.writeString(section);
        dest.writeDouble(id);
        dest.writeDouble(asset_id);
        dest.writeString(nytdsection);
        dest.writeString(byline);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(abstractType);
        dest.writeString(published_date);
        dest.writeString(source);

    }

}
