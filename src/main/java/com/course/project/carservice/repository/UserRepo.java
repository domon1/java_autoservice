package com.course.project.carservice.repository;

import com.course.project.carservice.domain.Role;
import com.course.project.carservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    //List<User> findByRole(Set<Role> role);

    Optional<User> findById(Long id);
}
