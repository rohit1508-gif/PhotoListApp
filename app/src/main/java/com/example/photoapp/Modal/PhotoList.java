package com.example.photoapp.Modal;

public class PhotoList {
    String albumId;
    String title;
    String thumbnailUrl;
    String url;
    public PhotoList(){}
    public PhotoList(String albumId, String title, String thumbnailUrl, String url) {
        this.albumId = albumId;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.url = url;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
