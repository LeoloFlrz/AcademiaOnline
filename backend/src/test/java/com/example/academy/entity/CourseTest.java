package com.example.academy.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseTest {


    public User testUser = new User(1L, "leolo", "admin", "leolo@leolo.com");
    public Course testCourse = new Course(1L, testUser, "prueba", "curso de prueba",2);

    @Test
    void should_get_the_title_of_the_course() {
        assertEquals("prueba", testCourse.getTitle());
    }

    @Test
    void should_get_the_description_of_the_course() {
        assertEquals("curso de prueba", testCourse.getDescription());
    }

    @Test
    void should_get_the_rating_of_the_course() {
        assertEquals(2, testCourse.getRating());
    }


    @Test
    void should_set_the_title_of_the_course() {
        testCourse.setTitle("pruebas");
        assertEquals("pruebas", testCourse.getTitle());
    }

    @Test
    void should_set_the_description_of_the_course() {
        testCourse.setDescription("probando los test");

        assertEquals("probando los test", testCourse.getDescription());
    }

    @Test
    void should_set_the_rating_of_the_course() {
        testCourse.setRating(1);
        assertEquals(1, testCourse.getRating());
    }
}