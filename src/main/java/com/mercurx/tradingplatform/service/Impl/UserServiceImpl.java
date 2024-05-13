package com.mercurx.tradingplatform.service.Impl;

import com.mercurx.tradingplatform.dao.HibernateDaoFactory;
import com.mercurx.tradingplatform.model.User;
import com.mercurx.tradingplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private HibernateDaoFactory hibernateDaoFactory;

    @Override
    public User getUserByUserName(String user) {
        return this.hibernateDaoFactory.getUserDao().getUserDetails(user);
    }

    @Override
    public User getUserByUserID(long id) {
        return this.hibernateDaoFactory.getUserDao().getUserById(id);
    }

    @Override
    public int createUser(User user) {
        return this.hibernateDaoFactory.getUserDao().addUser(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return this.hibernateDaoFactory.getUserDao().updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        //
    }
    @Override
    public List<User> getUsersList() {
        return this.hibernateDaoFactory.getUserDao().getUsersList();
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return convertToModuleData(this.hibernateDaoFactory.getUserDao().getUserDetails(s));
    }

    private org.springframework.security.core.userdetails.User convertToModuleData(User userData) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userData.getRole()));
        return new org.springframework.security.core.userdetails.User( userData.getUsername(),  userData.getPassword(), authorities);
    }
}
