package com.website.application.repository;

import com.website.application.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post,Long> {
    Post findById(long id);
    Post findBySenderUserName(String userName);
}
