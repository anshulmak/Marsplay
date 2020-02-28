package com.example.marsplay.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class doc {

    @SerializedName("id")
    private String id;
    @SerializedName("journal")
    private String journal;
    @SerializedName("eissn")
    private String eissn;
    @SerializedName("publication_date")
    private String publication_type;
    @SerializedName("article_type")
    private String article_type;
    @SerializedName("author_display")
    private List<String> author_display;
    @SerializedName("abstract")
    private List<String> abstracts;


    doc(String id, String journal, String eissn, String publication_type, String article_type, List<String> author_display, List<String> abstracts) {
        this.id = id;
        this.journal = journal;
        this.eissn = eissn;
        this.publication_type = publication_type;
        this.article_type = article_type;
        this.author_display = author_display;
        this.abstracts = abstracts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getEissn() {
        return eissn;
    }

    public void setEissn(String eissn) {
        this.eissn = eissn;
    }

    public String getPublication_type() {
        return publication_type;
    }

    public void setPublication_type(String publication_type) {
        this.publication_type = publication_type;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public List<String> getAuthor_display() {
        return author_display;
    }

    public void setAuthor_display(List<String> author_display) {
        this.author_display = author_display;
    }

    public List<String> getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(List<String> abstracts) {
        this.abstracts = abstracts;
    }
}
