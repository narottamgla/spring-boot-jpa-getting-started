package com.demo.service;

import com.demo.dto.UserDTO;
import com.demo.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

     User updateUser(User user);

     void deleteUser(Long id);
     List<User> getUserList();

     UserDTO getUserDetailsById(Long id);
}
