package com.ericksena.santanderbootcamp2023.service.Impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericksena.santanderbootcamp2023.domain.model.User;
import com.ericksena.santanderbootcamp2023.domain.repository.UserRepository;
import com.ericksena.santanderbootcamp2023.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("This user ID already exists.");
        }
        return userRepository.save(user);
    }

}
