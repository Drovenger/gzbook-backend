package com.gzbook.repository;

import com.gzbook.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

//    User findUserByUserEmail(String email);
//
//    Iterable<User> findUsersByUserNameContaining(String input);
//
    Optional<User> findByUsername(String nickName);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
