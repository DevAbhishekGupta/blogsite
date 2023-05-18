package com.blogsite.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogsite.blog.model.Blog;
import com.blogsite.blog.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired BlogRepository blogRepository;
	
	@Override
	public boolean isEmptyOrNull(Blog blog) {
		
		if(blog.getBlogName().trim().isEmpty() || blog.getBlogName()==null
				|| blog.getCategory().trim().isEmpty() || blog.getCategory()==null
				|| blog.getArticle().trim().isEmpty() || blog.getArticle()==null
				|| blog.getAuthorName().trim().isEmpty() || blog.getAuthorName()==null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Blog addBlog(Blog blog) {
		Blog result = blogRepository.save(blog);
		return result;
	}
	
	@Override
	public String validateLength(Blog blog) {
		String msg = "";
		
		if(blog.getBlogName().trim().length() < 20) {
			msg = "Blog Name should be of minimum 20 characters.\n";
		}
		if(blog.getCategory().trim().length() < 20) {
			msg = msg + "Category should be of minimum 20 characters.\n";
		}
		
		if(blog.getArticle().trim().length() < 1000) {
			msg = msg + "Article should be of minimum 1000 characters.\n";
		}
		
		return msg;
	}
}
