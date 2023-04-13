package com.knf.dev.repository;
import com.knf.dev.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

public interface CourseDesignationRepository extends JpaRepository<CourseDesignation, String> {
    
    public List<Course> findByCourseId(String courseId);
    
    public List<CourseDesignation> findAllCourseIdByDesignationLevel(int designationLevel);
}
