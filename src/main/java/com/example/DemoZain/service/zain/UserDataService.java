package com.example.DemoZain.service.zain;

import com.example.DemoZain.model.zain.UserData;
import com.example.DemoZain.repository.zain.UserDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    private final UserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public List<UserData> findAllUsers() {
        return userDataRepository.findAll();
    }

    public Optional<UserData> findUserById(Long id) {
        return userDataRepository.findById(id);
    }

    public UserData saveUser(UserData userData) {
        return userDataRepository.save(userData);
    }

    public Optional<UserData> updateUser(Long id, UserData updatedUser) {
        return userDataRepository.findById(id).map(existing -> {
            existing.setUsername(updatedUser.getUsername());
            existing.setEmail(updatedUser.getEmail());
            existing.setMobile(updatedUser.getMobile());
            return userDataRepository.save(existing);
        });
    }

    public boolean deleteUser(Long id) {
        if (userDataRepository.existsById(id)) {
            userDataRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
