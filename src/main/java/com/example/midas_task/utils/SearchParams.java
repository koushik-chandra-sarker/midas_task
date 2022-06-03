package com.example.midas_task.utils;

public class SearchParams {
    public String title;
    public Boolean published;

    public SearchParams() {
    }
    public SearchParams(String title, Boolean published) {
        this.title = title;
        this.published = published;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getPublished() {
        return published;
    }
    public void setPublished(Boolean published) {
        this.published = published;
    }
}
