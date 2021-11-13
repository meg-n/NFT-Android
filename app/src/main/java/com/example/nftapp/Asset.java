package com.example.nftapp;

public class Asset {
    private String id;
    private String imageURL;
    private String description;
    private int num_sales;

    public Asset(String id, String imgUrl, String description) {
        this.id = id;
        this.imageURL = imgUrl;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imageURL;
    }

    public void setImgUrl(String imgUrl) {
        this.imageURL = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
