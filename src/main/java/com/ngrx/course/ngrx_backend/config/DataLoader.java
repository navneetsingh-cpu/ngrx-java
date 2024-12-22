package com.ngrx.course.ngrx_backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngrx.course.ngrx_backend.Entity.Course;
import com.ngrx.course.ngrx_backend.Repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public DataLoader(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) {

        // Check if data already exists
        if (courseRepository.count() > 0) {
            System.out.println("Data already loaded. Skipping...");
            return;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/courses.json");

            if (inputStream == null) {
                throw new IllegalStateException("courses.json file not found in resources!");
            }

            JsonPayload payload = objectMapper.readValue(inputStream, JsonPayload.class);
            List<Course> courses = payload.getPayload();

            // Save to DB
            courseRepository.saveAll(courses);
            System.out.println("Courses loaded successfully!");

        } catch (Exception e) {
            System.err.println("Error loading courses: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static class JsonPayload {
        private List<Course> payload;

        public List<Course> getPayload() {
            return payload;
        }

        public void setPayload(List<Course> payload) {
            this.payload = payload;
        }
    }
}
