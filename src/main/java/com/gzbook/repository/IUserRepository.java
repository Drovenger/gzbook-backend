package com.gzbook.repository;

import com.gzbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    Iterable<User> findUsersByUserNameContaining(String input);

    Optional<User> findByUserName(String nickName);

    Optional<User> findByEmail(String email);

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);
}
