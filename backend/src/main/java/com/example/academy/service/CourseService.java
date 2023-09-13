package com.example.academy.service;

import com.example.academy.entity.Course;
import com.example.academy.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) {
            System.out.println("Course doesn`t exist");
        }
        courseRepository.deleteById(id);
    }
}
