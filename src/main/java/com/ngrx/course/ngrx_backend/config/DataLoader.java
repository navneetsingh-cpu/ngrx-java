package com.ngrx.course.ngrx_backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngrx.course.ngrx_backend.Entity.Course;
import com.ngrx.course.ngrx_backend.Entity.Lesson;
import com.ngrx.course.ngrx_backend.Repository.CourseRepository;
import com.ngrx.course.ngrx_backend.Repository.LessonRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor // Lombok annotation to generate constructor with required arguments
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;

    @Override
    public void run(String... args) {

        if (courseRepository.count() > 0) {
            System.out.println("Courses data already loaded. Skipping...");
        } else {
            loadCourses();
        }

        if (lessonRepository.count() > 0) {
            System.out.println("Lessons data already loaded. Skipping...");
        } else {
            loadLessons();
        }
    }

    private void loadCourses() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/json/courses.json");

            if (inputStream == null) {
                throw new IllegalStateException("courses.json file not found in resources!");
            }

            JsonPayload payload = objectMapper.readValue(inputStream, JsonPayload.class);
            List<Course> courses = payload.getPayload();

            courseRepository.saveAll(courses);
            System.out.println("Courses loaded successfully!");

        } catch (Exception e) {
            System.err.println("Error loading courses: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadLessons() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/json/lessons.json");

            if (inputStream == null) {
                throw new IllegalStateException("lessons.json file not found in resources!");
            }

            LessonJsonPayload payload = objectMapper.readValue(inputStream, LessonJsonPayload.class);
            List<Lesson> lessons = payload.getPayload();

            lessonRepository.saveAll(lessons);
            System.out.println("Lessons loaded successfully!");

        } catch (Exception e) {
            System.err.println("Error loading lessons: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Data // Lombok annotation to generate getters and setters
    public static class JsonPayload {
        private List<Course> payload;
    }

    @Data // Lombok annotation to generate getters and setters
    public static class LessonJsonPayload {
        private List<Lesson> payload;
    }
}
