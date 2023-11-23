package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    void save(User user);
    User showUser(long id);
    void editUser(User user);
    void deleteUser(long id);
    User findUserByName (String name);
    }

