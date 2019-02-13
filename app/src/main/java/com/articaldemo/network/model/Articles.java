package com.articaldemo.network.model;

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
//    private String updated;
//    private String org_facet;
//    private String per_facet;
//    private String geo_facet;

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
//        updated = in.readString();
//        org_facet = in.readString();
//        per_facet = in.readString();
//        geo_facet = in.readString();
//        uri = in.readString();
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
//
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
//
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
//
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
//
//    public String getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(String updated) {
//        this.updated = updated;
//    }
//
//    public String getOrg_facet() {
//        return org_facet;
//    }
//
//    public void setOrg_facet(String org_facet) {
//        this.org_facet = org_facet;
//    }
//
//    public String getPer_facet() {
//        return per_facet;
//    }
//
//    public void setPer_facet(String per_facet) {
//        this.per_facet = per_facet;
//    }
//
//    public String getGeo_facet() {
//        return geo_facet;
//    }
//
//    public void setGeo_facet(String geo_facet) {
//        this.geo_facet = geo_facet;
//    }
//
//    public String getUri() {
//        return uri;
//    }
//
//    public void setUri(String uri) {
//        this.uri = uri;
//    }
//
//    private String uri;
//
    @Override
    public int describeContents() {
        return 0;
    }
//
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
//        dest.writeString(updated);
//        dest.writeString(org_facet);
//        dest.writeString(per_facet);
//        dest.writeString(geo_facet);
//        dest.writeString(uri);
    }
//
//
//
//
//
//    {
//        "url": "https:\/\/www.nytimes.com\/2019\/02\/07\/opinion\/sunday\/girls-school-confidence.html",
//            "adx_keywords": "Women and Girls;Education (K-12);confidence;Anxiety and Stress;Psychology and Psychologists;Workplace Environment",
//            "subsection": "sunday review",
//            "email_count": 1,
//            "count_type": "EMAILED",
//            "column": null,
//            "eta_id": 0,
//            "section": "Opinion",
//            "id": 100000006345874,
//            "asset_id": 100000006345874,
//            "nytdsection": "opinion",
//            "byline": "By LISA DAMOUR",
//            "type": "Article",
//            "title": "Why Girls Beat Boys at School and Lose to Them at the Office",
//            "abstract": "Hard work and discipline help girls outperform boys in class, but that advantage disappears in the work force. Is school the problem?",
//            "published_date": "2019-02-07",
//            "source": "The New York Times",
//            "updated": "2019-02-11 17:39:42",
//            "des_facet": [
//        "WOMEN AND GIRLS",
//                "EDUCATION (K-12)",
//                "ANXIETY AND STRESS",
//                "PSYCHOLOGY AND PSYCHOLOGISTS",
//                "WORKPLACE ENVIRONMENT"
//      ],
//        "org_facet": "",
//            "per_facet": "",
//            "geo_facet": "",
//            "media": [
//        {
//            "type": "image",
//                "subtype": "photo",
//                "caption": "",
//                "copyright": "Wenting Li",
//                "approved_for_syndication": 1,
//                "media-metadata": [
//            {
//                "url": "https:\/\/static01.nyt.com\/images\/2019\/02\/10\/opinion\/sunday\/10damour\/10damour-thumbStandard.jpg",
//                    "format": "Standard Thumbnail",
//                    "height": 75,
//                    "width": 75
//            },
//            {
//                "url": "https:\/\/static01.nyt.com\/images\/2019\/02\/10\/opinion\/sunday\/10damour\/10damour-mediumThreeByTwo210.jpg",
//                    "format": "mediumThreeByTwo210",
//                    "height": 140,
//                    "width": 210
//            },
//            {
//                "url": "https:\/\/static01.nyt.com\/images\/2019\/02\/10\/opinion\/sunday\/10damour\/10damour-mediumThreeByTwo440.jpg",
//                    "format": "mediumThreeByTwo440",
//                    "height": 293,
//                    "width": 440
//            }
//          ]
//        }
//      ],
//        "uri": "nyt:\/\/article\/2eddf881-211c-5e35-8364-12eeb20b28db"
//    }
}
