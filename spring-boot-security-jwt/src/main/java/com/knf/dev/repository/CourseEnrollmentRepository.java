package com.knf.dev.repository;
import com.knf.dev.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CourseEnrollmentRepository  extends JpaRepository<CourseEnrollment, String> {
    
    public List<Course> findAllCourseByEmpId(String empId);
    public List<Course> findByCourseId(String courseId);
    public List<CourseEnrollment> findAllCourseIdByEmpId(String EmpId);
}