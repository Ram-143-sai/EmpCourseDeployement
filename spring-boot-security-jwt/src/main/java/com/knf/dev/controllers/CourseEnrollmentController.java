package com.knf.dev.controllers;
import com.knf.dev.security.services.*;
import com.knf.dev.models.*;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class CourseEnrollmentController {
	
	@Autowired
	private CourseEnrollmentService courseEnrollmentService;
    @Autowired
    private CourseService courseService;
	
	@RequestMapping("/admin/courseIdEnrolled/{id}")
	public List<CourseEnrollment> getAllCourseIds(@PathVariable String id) {
		return courseEnrollmentService.getAllCoursesIdByEmpId(id);
	}
	
    @GetMapping("enrolledCourses/{id}")
	public List<Course> getAllCourse(@PathVariable String id) {
		return courseEnrollmentService.getAllCoursesByCourseId(id);
	}

	@RequestMapping(method = RequestMethod.POST,value = "enrollCourse")
	public void productSave(@RequestBody CourseEnrollment productmodel) {
		courseEnrollmentService.enrollCourse(productmodel);
		
	}

}