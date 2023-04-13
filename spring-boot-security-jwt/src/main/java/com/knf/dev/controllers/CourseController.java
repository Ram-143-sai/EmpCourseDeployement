package com.knf.dev.controllers;
import com.knf.dev.security.services.*;
import com.knf.dev.models.*;

import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getAllCourse() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/admin/course/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/admin/addCourse")
	public void productSave(@RequestBody Course productmodel) {
		courseService.addCourse(productmodel);
		
	}
	@RequestMapping(method = RequestMethod.POST,value="/admin/productEdit/{id}")
	public void productEditSave(@RequestBody Course productmodel,@PathVariable String id ) {
		courseService.updateCourse(productmodel,id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE,value="/admin/delete/{id}")
	public void productDelete(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
