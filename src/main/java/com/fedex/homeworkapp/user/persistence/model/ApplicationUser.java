package com.fedex.homeworkapp.user.persistence.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fedex.homeworkapp.comment.CommentModel;
import com.fedex.homeworkapp.homework.Homework;
import com.fedex.homeworkapp.post.PostModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String username;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "app_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private List<UserRole> roles = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "postsUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostModel> usersPosts;

    @JsonManagedReference
    @OneToMany(mappedBy = "commentsUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentModel> usersComments;

    @JsonManagedReference
    @OneToMany(mappedBy = "homeworksUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Homework> usersHomework;

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
