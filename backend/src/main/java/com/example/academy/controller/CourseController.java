package com.example.academy.controller;

import com.example.academy.entity.Course;
import com.example.academy.entity.User;
import com.example.academy.service.CourseService;
import com.example.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

   /* @PostMapping()
    public ResponseEntity<String> AddCourse(@RequestBody Course course) {
        User selectedUser = userService.getAllUser().stream().filter(user -> user.getId().equals(course.getUser().getId())).findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: "+course.getUser().getId()));
        course.setUser((selectedUser));
        courseService.createCourse(course);
        return ResponseEntity.ok("Course successfully added");
    }*/

    @GetMapping
    public ResponseEntity<List<Course>> AllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id does not exist" + id));
    }

   /* @PutMapping("/{id}")
    public ResponseEntity<String> editCourse(@RequestBody Course course, @PathVariable Long id) {
        if (courseService.getCourseById(id).isPresent()) {
            User selectedUser = userService.getAllUser().stream().filter(user -> user.getId().equals(course.getUser().getId())).findFirst()
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + course.getUser().getId()));
            course.setUser((selectedUser));
            courseService.updateCourse(course);

            return ResponseEntity.ok("Task Updated Successfully!");
        }
        return ResponseEntity.notFound().build();
    }*/

    @DeleteMapping("/{id}/deleted")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);

        try {
            courseService.deleteCourse(id);
            return ResponseEntity.ok("Course successfully deleted");
        }catch (ResponseStatusException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
