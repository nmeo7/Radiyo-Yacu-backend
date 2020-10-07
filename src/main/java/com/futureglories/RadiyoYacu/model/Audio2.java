package com.futureglories.RadiyoYacu.model;

import java.io.InputStream;

public class Audio2 {
    private String title;
    private InputStream stream;
    
    public Audio2() {
        super();
    }

    public Audio2(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Video [title=" + title + "]";
    }

}