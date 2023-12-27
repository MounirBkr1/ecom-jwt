package com.mnr.entity;

import jakarta.persistence.*;
import com.mnr.entity.Role;

import java.util.Set;

@Entity
public class User {

    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

//    Set A collection that contains no duplicate elements
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLE",
            joinColumns = {
                 @JoinColumn(name="USER_ID")
            },
            inverseJoinColumns = {
            @JoinColumn(name="ROLE_ID")
            }
    )

    private Set <Role> roles;

    //getters & setters
    public String getUserName() {
        return userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
