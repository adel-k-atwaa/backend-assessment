package com.example.SystemDesign.Service.DTO;

import com.example.SystemDesign.Domain.Group;
import com.example.SystemDesign.Domain.Permission;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private Long id;

    private String email;


    private String password;


    private Group group;


    private Permission permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
