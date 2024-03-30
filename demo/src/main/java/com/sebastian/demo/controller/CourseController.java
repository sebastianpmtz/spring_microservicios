package com.sebastian.demo.controller;

import com.sebastian.demo.model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    private List<Course> courses;
    @PostConstruct
    public void init(){
        courses = new ArrayList<>();
        courses.add(new Course(1,"Spring", 25, "Monday, Tuesday, Friday"));
        courses.add(new Course(2,"React", 50, "Monday"));
        courses.add(new Course(3,"Flutter", 10, "Wednesday, Friday"));
        courses.add(new Course(4,"MySQL", 200, "Weekdays"));
        courses.add(new Course(5, ".Net", 75, "Weekend"));
    }

    @PostMapping(value = "Course/createCourse", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> createCourse(@RequestBody Course course){

        courses.add(course);

        return courses;
    }

    @GetMapping(value = "Course/getAllCourses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getAllCourses(){
        return courses;
    }
    @GetMapping(value = "Course/getCourse", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourse(){
        return new Course(1,"Java-Microservice", 50, "Weekend");
    }

    @GetMapping(value = "Course/getCourseById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourseById(@RequestParam("id") int id){
        Course aux = new Course();
        for(Course c:courses) {
            if(c.getId() == id){
                aux = c;
            }
        }
        return aux;
    }

    @PutMapping(value = "Course/updateCourseById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> updateCourseById(@RequestBody Course course){

        for(int i=0; i < courses.size(); i++){
            if(courses.get(i).getId() == course.getId()){
                courses.set(i, course);
            }
        }
        return courses;
    }

    @DeleteMapping(value = "Course/deleteCourseById")
    public List<Course> deleteCourseById(@RequestParam("id") int id){

        courses.removeIf(c -> c.getId() == id);
        return courses;
    }

}
