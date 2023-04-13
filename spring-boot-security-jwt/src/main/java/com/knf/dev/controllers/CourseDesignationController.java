package com.knf.dev.controllers;
import com.knf.dev.security.services.*;
import com.knf.dev.models.*;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class CourseDesignationController {
	
	@Autowired
	private CourseDesignationService courseDesignationService;
    
	
	
    @RequestMapping("/{level}/availableCourse")
	public List<Course> getAllCourse(@PathVariable int level) {
		return courseDesignationService.getAllCoursesByDes(level);
	}
	@RequestMapping("availableCourses/{empId}")
	public List<Course> getAvailableCoursesForEmp(@PathVariable Long empId) {
		return courseDesignationService.getAvaialbleCoursesForEmp(empId);
	}

}
