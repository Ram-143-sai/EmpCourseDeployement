package com.knf.dev.repository;
import com.knf.dev.models.*;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository  extends JpaRepository<Course, String> {

    Course findByCourseId(String courseId);
    List<Course> findAllCourseByCourseId(String courseId);
}
