package com.pacto.web.repository;

import com.pacto.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findBySurname(String surname);

    @Override
    List<User> findAll();
}