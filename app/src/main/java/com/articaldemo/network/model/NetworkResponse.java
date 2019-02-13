package com.articaldemo.network.model;

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

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public List<Articles> getResults() {
        return results;
    }

    public void setResults(List<Articles> results) {
        this.results = results;
    }

    private String copyright;
    private int num_results;

    List<Articles> results = new ArrayList<>();
}
