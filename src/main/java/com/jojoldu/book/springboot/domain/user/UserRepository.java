package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
