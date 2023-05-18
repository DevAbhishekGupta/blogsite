package com.blogsite.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blogsite.blog.model.Blog;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {

}
