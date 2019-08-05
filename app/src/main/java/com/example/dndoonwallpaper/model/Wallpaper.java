package com.example.dndoonwallpaper.model;

public class Wallpaper {
    private String thumbnail;
    private String imgUrl;
    private String title;
    private String owner;

    public Wallpaper(String thumbnail, String imgUrl, String title, String owner) {
        this.thumbnail = thumbnail;
        this.imgUrl = imgUrl;
        this.title = title;
        this.owner = owner;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
