package com.gzbook.service.user;


import com.gzbook.model.user.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    void deleteUser(Long id);

    Iterable<User> findAllUser();

    User findUserById(Long id);

    User findUserByEmail(String email);

    Iterable<User> findUserByName(String input);

    Optional<User> findByUsername(String username);

    boolean emailExist(String email);
}
