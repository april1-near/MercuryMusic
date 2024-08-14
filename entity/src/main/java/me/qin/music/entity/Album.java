package me.qin.music.entity;

public class Album {
    private Integer albumId;
    private String name;
    private String author;
    private String coverUrl;

    public Album() {
    }

    public Album(Integer albumId, String name, String author, String coverUrl) {
        this.albumId = albumId;
        this.name = name;
        this.author = author;
        this.coverUrl = coverUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
}