package com.fedex.homeworkapp.user.service;


import com.fedex.homeworkapp.security.model.UserContext;
import com.fedex.homeworkapp.user.exceptions.RegistrationAttemptException;
import com.fedex.homeworkapp.user.exceptions.UserRoleNotFoundException;
import com.fedex.homeworkapp.user.persistence.model.ApplicationUser;
import com.fedex.homeworkapp.user.persistence.model.UserRole;
import com.fedex.homeworkapp.user.persistence.repository.ApplicationUserRepository;
import com.fedex.homeworkapp.user.utility.ApplicationUserDTO;
import com.fedex.homeworkapp.user.utility.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationUserService {

    private ApplicationUserRepository applicationUserRepository;
    private PasswordEncoder encoder;
    private RoleService roleService;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository,
                                  PasswordEncoder encoder, RoleService roleService) {
        this.applicationUserRepository = applicationUserRepository;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    public UserContext createUserContext(String username) {
        ApplicationUser applicationUser = findByUserName(username);

        if (applicationUser.getRoles() == null)
            throw new InsufficientAuthenticationException("User has no roles assigned");
        List<GrantedAuthority> authorities = applicationUser.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRoleEnum().authority()))
                .collect(Collectors.toList());

        return UserContext.create(applicationUser.getUsername(), authorities);
    }

    public ApplicationUser findByUserName(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public void registerApplicationUser(ApplicationUserDTO applicationUserDTO)
            throws RegistrationAttemptException, UserRoleNotFoundException {

        if (applicationUserRepository.existsByEmail(applicationUserDTO.getEmail())) {
            throw new RegistrationAttemptException("There is an account with that email address: " + applicationUserDTO.getEmail());
        }
        if (applicationUserRepository.existsByUsername(applicationUserDTO.getUsername())) {
            throw new RegistrationAttemptException("There is an account with that user name: " + applicationUserDTO.getUsername());
        }

            final ApplicationUser applicationUser = new ApplicationUser();
            List<UserRole> userRoles = new ArrayList<>();
            userRoles.add(roleService.getRoleBasedOnEmail(applicationUserDTO.getEmail()));
            applicationUser.setUsername(applicationUserDTO.getUsername());
            applicationUser.setEmail(applicationUserDTO.getEmail());
            applicationUser.setPassword(encoder.encode(applicationUserDTO.getPassword()));
            applicationUser.setRoles(userRoles);
            applicationUserRepository.save(applicationUser);

    }

    public List<String> findAllUsernames() {
        List<ApplicationUser> allUsers = applicationUserRepository.findAll();
        return allUsers.stream().map(ApplicationUser::getUsername).collect(Collectors.toList());
    }
    public List<ApplicationUser> findStudents() {
        return applicationUserRepository.findApplicationUsersByRoles(Role.STUDENT);
    }

    public List<ApplicationUser> findTeachers() {
        return applicationUserRepository.findApplicationUsersByRoles(Role.TEACHER);
    }
}
