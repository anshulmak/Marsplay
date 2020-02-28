package com.example.marsplay.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class model {

    @SerializedName("numFound")
    private String numFound;
    @SerializedName("start")
    private String start;
    @SerializedName("maxScore")
    private String maxScore;
    @SerializedName("docs")
    private List<doc> docs;

    model(String numFound,String start,String maxScore, List<doc> docs){
        this.numFound = numFound;
        this.start = start;
        this.maxScore = maxScore;
        this.docs = docs;
    }

    public String getNumFound() {
        return numFound;
    }

    public void setNumFound(String numFound) {
        this.numFound = numFound;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public List<doc> getDocs() {
        return docs;
    }

    public void setDocs(List<doc> docs) {
        this.docs = docs;
    }
}
