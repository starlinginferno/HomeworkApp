package com.fedex.homeworkapp;

import com.fedex.homeworkapp.user.persistence.model.UserRole;
import com.fedex.homeworkapp.user.persistence.repository.RoleRepository;
import com.fedex.homeworkapp.user.utility.Role;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class HomeworkappApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkappApplication.class, args);
    }

    @Bean
    ApplicationRunner init(RoleRepository roleRepository) {
        return args -> {
            Stream.of(Role.STUDENT, Role.TEACHER).forEach(role -> {
                UserRole userRole = new UserRole();
                userRole.setRoleEnum(role);
                roleRepository.save(userRole);
            });
            roleRepository.findAll().forEach(System.out::println);
        };
    }
}
