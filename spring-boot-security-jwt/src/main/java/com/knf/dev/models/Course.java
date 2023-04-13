package com.knf.dev.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "course")
@Entity
public class Course {
    
	public Course() {
		
	}
	public Course(String courseId, String courseName, String content,String imageUrl,String instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.content = content;
		this.imageUrl=imageUrl;
		this.instructor=instructor;
	}

    @Id
	private String courseId;
	private String instructor;
	private String courseName;
	private String content;
	private String imageUrl;

    public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getContent() {
		return content;
	}
	public void setQuantity(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String ins) {
		this.instructor = ins;
	}
}
