package com.example.test.data.details;

import com.google.gson.annotations.SerializedName;

public class UserDetail {
    private long id;
    private String login;
    @SerializedName("avatar_url")
    private String avatar_url;
    private String name;
    private String bio;
    private boolean site_admin;
    private String location;
    private String blog;

    public UserDetail(long id, String login, String avatar_url, String name, String bio, boolean site_admin, String location, String blog) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.name = name;
        this.bio = bio;
        this.site_admin = site_admin;
        this.location = location;
        this.blog = blog;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public boolean isSiteAdmin() {
        return site_admin;
    }

    public String getLocation() {
        return location;
    }

    public String getBlog() {
        return blog;
    }

    @Override
    public String toString() {
        return "DetailData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", site_admin=" + site_admin +
                ", location='" + location + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }
}