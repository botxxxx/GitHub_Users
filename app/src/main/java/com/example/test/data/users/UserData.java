package com.example.test.data.users;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "users")
public class UserData {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String login;
    private String avatar_url;
    private boolean site_admin;

    public UserData(Long id, String login, String avatar_url, Boolean site_admin) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.site_admin = site_admin;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", site_admin=" + site_admin +
                '}';
    }
}