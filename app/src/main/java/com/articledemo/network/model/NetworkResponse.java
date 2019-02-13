package com.articledemo.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NetworkResponse {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public List<Articles> getResults() {
        return results;
    }

    public void setResults(List<Articles> results) {
        this.results = results;
    }

    private String copyright;
    @SerializedName("num_results")
    private int numResults;

    List<Articles> results = new ArrayList<>();
}
