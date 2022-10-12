package ru.javamentor.preproject.service;


import ru.javamentor.preproject.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void save(User user);
    void remove(int id);
    void update(int id, User updatedUser);
    User show(int id);
}
