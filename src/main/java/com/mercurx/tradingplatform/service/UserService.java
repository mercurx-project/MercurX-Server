package com.mercurx.tradingplatform.service;

import com.mercurx.tradingplatform.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    User getUserByUserName(String userName);
    User getUserByUserID(long id);
    int createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getUsersList();
    UserDetails loadUserByUsername(String userName);
}

