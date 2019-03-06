package com.fedex.homeworkapp.user.persistence.model;

import javax.persistence.*;

import com.fedex.homeworkapp.user.utility.Role;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class UserRole {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role roleEnum;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<ApplicationUser> user = new ArrayList<>();

}
