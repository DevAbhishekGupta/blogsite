package com.blogsite.blog.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogsite.blog.model.Blog;
import com.blogsite.blog.service.BlogService;

@RestController
@RequestMapping("api/v1.0/blogsite")
public class BlogController {

	@Autowired BlogService blogService;
	
	@PostMapping("/user/blogs/add/{blogName}")
	public ResponseEntity<?> createBlog(@RequestBody Blog blog, @PathVariable("blogName") String blogName) {
		if(!blogService.isEmptyOrNull(blog) && blogName!= null) {
			String msg = blogService.validateLength(blog).trim();
			if(!msg.isEmpty()) {
				blog.setBlogName(blogName);
				
				Date creationAt = new Date();
				blog.setCreatedAt(creationAt);
				Blog result = blogService.addBlog(blog);
				return new ResponseEntity<Blog>(result, HttpStatus.OK);
			}
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>("All Fields are Mandatory", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
