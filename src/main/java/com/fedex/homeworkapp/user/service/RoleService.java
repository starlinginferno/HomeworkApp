package com.fedex.homeworkapp.user.service;

import com.fedex.homeworkapp.user.utility.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fedex.homeworkapp.user.exceptions.UserRoleNotFoundException;
import com.fedex.homeworkapp.user.persistence.repository.RoleRepository;
import com.fedex.homeworkapp.user.persistence.model.UserRole;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserRole findById(Long id) throws UserRoleNotFoundException {
        return roleRepository.findById(id).orElseThrow(() -> new UserRoleNotFoundException("User role not found by this id: " + id));
    }

    public UserRole getRoleBasedOnEmail(String email) throws UserRoleNotFoundException {
        if(email.contains("@fedex.edu")) {
            return findById(2L);
        } else {
            return findById(1L);
        }
    }
}
