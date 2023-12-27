package com.mnr.services;


import com.mnr.dao.RoleDao;
import com.mnr.dao.UserDao;
import com.mnr.entity.Role;
import com.mnr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user){
        userDao.save(user);
        return user;
    }


    //juste to put initial value when we create a new table or when create in app-properties is maintained
    public void initRolesAndUSer(){

        Role adminRole= new Role();
        adminRole.setRoleName("admin");
        adminRole.setRoleDescription("admin role");
        roleDao.save(adminRole);

        Role userRole= new Role();
        userRole.setRoleName("user");
        userRole.setRoleDescription("user role");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");

        Set<Role> adminRoles= new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("mounir");
        user.setUserLastName("bkr");
        user.setUserName("mounir123");
        user.setUserPassword("mounir@pass");

        Set<Role> userRoles= new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        userDao.save(user);



    }
}
