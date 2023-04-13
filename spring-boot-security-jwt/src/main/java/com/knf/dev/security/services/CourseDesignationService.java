package com.knf.dev.security.services;
import com.knf.dev.repository.*;
import com.knf.dev.models.*;
 
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseDesignationService {
	
	@Autowired
	private CourseDesignationRepository courseDesignationRepository;
    @Autowired
    private CourseRepository courseRepository;
	@Autowired
    private UserRepository employeeRepository;
	
	

    public List<Course> getAllCoursesByDes(int designationLevel){
		List<CourseDesignation> courseModels = new ArrayList<>();
		// courseRepository.findAll().forEach(courseModels::add);
        courseDesignationRepository.findAllCourseIdByDesignationLevel(designationLevel).forEach(courseModels::add);
		List<String> cid = new ArrayList<>();
        for (CourseDesignation ce : courseModels) {
            cid.add(ce.getCourseId());
        }
        List<Course> course = new ArrayList<>();
        for (String c : cid) {
            course.add(courseRepository.findByCourseId(c));
        }
        
        return course;
	}

	public List<Course> getAvaialbleCoursesForEmp(Long empId){
		User e;
		e= employeeRepository.findById(empId);
		int dsl;
		dsl= e.getDesignationLevel();
		List<CourseDesignation> courseModels = new ArrayList<>();
		// courseRepository.findAll().forEach(courseModels::add);
        courseDesignationRepository.findAllCourseIdByDesignationLevel(dsl).forEach(courseModels::add);
		List<String> cid = new ArrayList<>();
        for (CourseDesignation ce : courseModels) {
            cid.add(ce.getCourseId());
        }
        List<Course> course = new ArrayList<>();
        for (String c : cid) {
            course.add(courseRepository.findByCourseId(c));
        }
        
        return course;
	}
	
	// public Course getCourse(String id) {
	// 	//return topics.stream().filter(t->t.getTopicId().equals(id)).findFirst().get();
	// 	return courseRepository.findById(id).filter(t->t.getCourseId().equals(id)).get();
	// }

	// public void addCourse(Course course) {
	// 	//topics.add(topic);
	// 	courseRepository.save(course);
	// }

	// public void updateCourse(Course course, String id) {
	// 	courseRepository.save(course);
	// }

	// public void deleteCourse(String id) {
	// 	courseRepository.deleteById(id);
	// }
}
