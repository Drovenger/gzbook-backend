package com.gzbook.repository;

import com.gzbook.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

//    User findUserByUserEmail(String email);
//
//    Iterable<User> findUsersByUserNameContaining(String input);
//
//    Optional<User> findByUserName(String nickName);
//
//    Optional<User> findByUserEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
