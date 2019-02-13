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
    @SerializedName("adx_keywords")
    private String adxKeywords;
    private String subsection;
    @SerializedName("email_count")
    private String emailCount;
    private String column;
    @SerializedName("eta_id")
    private String etaId;
    private String section;
    private double id;
    @SerializedName("asset_id")
    private double assetId;
    private String nytdsection;
    private String byline;
    private String type;
    private String title;
    @SerializedName("abstract")
    private String abstractType;
    @SerializedName("published_date")
    private String publishedDate;
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
        adxKeywords = in.readString();
        subsection = in.readString();
        emailCount = in.readString();
        column = in.readString();
        etaId = in.readString();
        section = in.readString();
        id = in.readDouble();
        assetId = in.readDouble();
        nytdsection = in.readString();
        byline = in.readString();
        type = in.readString();
        title = in.readString();
        abstractType = in.readString();
        publishedDate = in.readString();
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

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getEmailCount() {
        return emailCount;
    }

    public void setEmailCount(String emailCount) {
        this.emailCount = emailCount;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getEtaId() {
        return etaId;
    }

    public void setEtaId(String etaId) {
        this.etaId = etaId;
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

    public double getAssetId() {
        return assetId;
    }

    public void setAssetId(double assetId) {
        this.assetId = assetId;
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
    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
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
        dest.writeString(adxKeywords);
        dest.writeString(subsection);
        dest.writeString(emailCount);
        dest.writeString(column);
        dest.writeString(etaId);
        dest.writeString(section);
        dest.writeDouble(id);
        dest.writeDouble(assetId);
        dest.writeString(nytdsection);
        dest.writeString(byline);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(abstractType);
        dest.writeString(publishedDate);
        dest.writeString(source);

    }

}
