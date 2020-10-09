package com.gzbook.repository;

import com.gzbook.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    Iterable<User> findUsersByUsernameContaining(String input);

    Optional<User> findByUsername(String nickName);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
