package me.qin.music.entity;

public class User {
    private Integer userId;

    private String name;

    private String gender;

    private Integer age;

    private String email;

    private Integer permission;

    private String passwd;

    public User() {
    }

    public User(Integer userId, String name, String gender, Integer age, String email, Integer permission, String passwd) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.permission = permission;
        this.passwd = passwd;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", permission=" + permission +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}