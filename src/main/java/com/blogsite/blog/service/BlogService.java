package com.blogsite.blog.service;

import org.springframework.stereotype.Component;

import com.blogsite.blog.model.Blog;

@Component
public interface BlogService {

	public boolean isEmptyOrNull(Blog blog);
	
	public Blog addBlog(Blog blog);
	
	public String validateLength(Blog blog);
	
}
