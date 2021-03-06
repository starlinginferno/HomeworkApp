package com.fedex.homeworkapp.user.persistence.repository;

import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import com.fedex.homeworkapp.user.utility.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<ApplicationUser> findApplicationUsersByRoles(Role roleEnum);
}
