package com.holanswide.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/9/22
 */
@Repository
@ConfigurationProperties(prefix = "default-user")
public class User {
    int uid;
    String username;
    String password;

    public User(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
