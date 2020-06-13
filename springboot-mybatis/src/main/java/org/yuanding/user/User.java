package org.yuanding.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class User {

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getCreateTime() {
        return createTime;
    }

    @JsonIgnore
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    private int id;

    private String username;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Timestamp createTime;

    @JsonIgnore
    private boolean isDeleted;
}
