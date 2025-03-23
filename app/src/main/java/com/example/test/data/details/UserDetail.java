package com.example.test.data.details;

import java.util.Objects;

public class UserDetail {
    private long id;
    private String login;
    private String avatarUrl;
    private String name;
    private String bio;
    private boolean siteAdmin;
    private String location;
    private String blog;

    public UserDetail(long id, String login, String avatarUrl, String name, String bio, boolean siteAdmin, String location, String blog) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.bio = bio;
        this.siteAdmin = siteAdmin;
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
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
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
                ", avatarUrl='" + avatarUrl + '\'' +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", siteAdmin=" + siteAdmin +
                ", location='" + location + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }
}