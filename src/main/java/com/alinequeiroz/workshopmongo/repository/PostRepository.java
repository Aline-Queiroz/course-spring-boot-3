package com.alinequeiroz.workshopmongo.repository;

import com.alinequeiroz.workshopmongo.domain.Post;
import com.alinequeiroz.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
