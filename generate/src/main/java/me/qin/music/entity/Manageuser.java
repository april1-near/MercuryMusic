package me.qin.music.entity;

public class Manageuser {
    private Integer userId;

    private String name;

    private String managePasswd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getManagePasswd() {
        return managePasswd;
    }

    public void setManagePasswd(String managePasswd) {
        this.managePasswd = managePasswd == null ? null : managePasswd.trim();
    }
}