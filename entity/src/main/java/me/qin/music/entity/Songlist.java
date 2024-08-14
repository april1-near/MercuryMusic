package me.qin.music.entity;

public class Songlist {
    private Integer listId;

    private String name;

    private Integer creator;

    private String createTime;

    private String coverUrl;

    private Integer hide;

    public Songlist() {
    }

    public Songlist(Integer listId, String name, Integer reator, String createTime, String coverUrl, Integer hide) {
        this.listId = listId;
        this.name = name;
        this.creator = reator;
        this.createTime = createTime;
        this.coverUrl = coverUrl;
        this.hide = hide;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl == null ? null : coverUrl.trim();
    }

    public Integer getHide() {
        return hide;
    }

    public void setHide(Integer hide) {
        this.hide = hide;
    }

    @Override
    public String toString() {
        return "Songlist{" +
                "listId=" + listId +
                ", name='" + name + '\'' +
                ", reator=" + creator +
                ", createTime=" + createTime +
                ", coverUrl='" + coverUrl + '\'' +
                ", hide=" + hide +
                '}';
    }
}