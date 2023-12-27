package com.mnr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Role {
    @Id
    public String roleName;
    private String roleDescription;


    //getters & setters
    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
