package com.fedex.homeworkapp.user.persistence.repository;


import com.fedex.homeworkapp.user.persistence.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findById(Long id);
}
