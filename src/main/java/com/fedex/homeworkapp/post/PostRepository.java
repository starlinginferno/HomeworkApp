package com.fedex.homeworkapp.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
    List<PostModel> findAllBySubject(Subject subject);
}
