package com.ericksena.santanderbootcamp2023.service;

import com.ericksena.santanderbootcamp2023.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User user);
}
