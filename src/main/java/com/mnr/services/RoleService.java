package com.mnr.services;

import com.mnr.dao.RoleDao;
import com.mnr.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;


    public  Role createNewRole(Role role){
        roleDao.save(role);
        return role;
    }

}
