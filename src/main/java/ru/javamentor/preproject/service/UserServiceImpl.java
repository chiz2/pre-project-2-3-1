package ru.javamentor.preproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.preproject.dao.UserRepository;
import ru.javamentor.preproject.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public void save(User user) {
        userRepository.add(user);
    }

    @Override
    public User show(int id) {
        return userRepository.show(id);
    }

    @Override
    public void remove(int id) {
        userRepository.remove(id);
    }

    @Override
    public void update(int id, User updateUser) {
        userRepository.update(id, updateUser);
    }
}
