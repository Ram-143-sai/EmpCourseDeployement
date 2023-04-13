package com.knf.dev.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import java.util.Collection;


@Table(name = "course_designation")
@Entity
public class CourseDesignation {
    

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    int designationLevel;
    String courseId;

    public CourseDesignation() {
		
	}
	public CourseDesignation(int dl, String courseId) {
        super();
		this.designationLevel = dl;
		this.courseId = courseId;
	}

    public int getDesignationLevel() {
		return designationLevel;
	}
	public void setDesignationLevel(int dl) {
		this.designationLevel = dl;
	}
    public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
