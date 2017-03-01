package com.phonebook.service;

import com.phonebook.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
