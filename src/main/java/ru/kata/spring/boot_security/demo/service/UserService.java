package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    void saveUser(User user);
    User getUserInfo(long id);
    void editUser(User user);
    void deleteUser(long id);

}
