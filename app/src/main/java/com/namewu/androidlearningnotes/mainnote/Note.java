package com.namewu.androidlearningnotes.mainnote;

/**
 * Created by Administrator on 2017/7/26.
 */

public class Note {
    private String title;
    private String context;
    public Note(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
