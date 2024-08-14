package me.qin.music.entity;

public class Song {
    private Integer songId;

    private String name;

    private String author;

    private String albumName;

    private String albumcoverUrl;

    private String lyricUrl;

    private String fileUrl;

    public Song() {
    }

    public Song(Integer songId, String name, String author, String albumName, String albumcoverUrl, String lyricUrl, String fileUrl) {
        this.songId = songId;
        this.name = name;
        this.author = author;
        this.albumName = albumName;
        this.albumcoverUrl = albumcoverUrl;
        this.lyricUrl = lyricUrl;
        this.fileUrl = fileUrl;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumcoverUrl() {
        return albumcoverUrl;
    }

    public void setAlbumcoverUrl(String albumcoverUrl) {
        this.albumcoverUrl = albumcoverUrl == null ? null : albumcoverUrl.trim();
    }

    public String getLyricUrl() {
        return lyricUrl;
    }

    public void setLyricUrl(String lyricUrl) {
        this.lyricUrl = lyricUrl == null ? null : lyricUrl.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumcoverUrl='" + albumcoverUrl + '\'' +
                ", lyricUrl='" + lyricUrl + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }
}