package ru.javamentor.preproject.dao;

import ru.javamentor.preproject.model.User;

import java.util.List;

public interface UserRepository {
   void add(User user);
   void update(int id, User updatedUser);
   void remove(int id);
   User show(int id);
   List<User> getUsers();
}
