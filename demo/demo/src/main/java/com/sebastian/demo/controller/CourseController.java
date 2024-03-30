package com.sebastian.demo.controller;

import com.sebastian.demo.model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    private List<Course> courses;
    @PostConstruct
    public void init(){
        courses = new ArrayList<>();
        courses.add(new Course("Spring", 25, "Monday, Tuesday, Friday"));
        courses.add(new Course("React", 50, "Monday"));
        courses.add(new Course("Flutter", 10, "Wednesday, Friday"));
        courses.add(new Course("MySQL", 200, "Weekdays"));
        courses.add(new Course(".Net", 75, "Weekend"));
    }
    @GetMapping(value = "getAllCourses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getAllCourses(){
        return courses;
    }
    @GetMapping(value = "getCourse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourse(){
        return new Course("Java-Microservice", 50, "Weekend");
    }

    @GetMapping(value = "getCourseByName", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourseByName(@RequestParam("name") String name){
        Course aux = new Course();
        for(Course c:courses) {
            if(c.getName().contains(name)){
                aux = c;
            }
        }
        return aux;
    }

}
