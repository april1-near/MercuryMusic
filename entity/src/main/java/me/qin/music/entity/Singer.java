package me.qin.music.entity;

public class Singer {
    private Integer singerId;

    private String name;

    private String introduction;

    private String photoUrl;

    public Singer() {
    }

    public Singer(Integer singerId, String name, String introduction, String photoUrl) {
        this.singerId = singerId;
        this.name = name;
        this.introduction = introduction;
        this.photoUrl = photoUrl;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerId=" + singerId +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}