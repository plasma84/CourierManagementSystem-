package com.cms.dao;

import com.cms.entity.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUserById(int userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int userId);
}
