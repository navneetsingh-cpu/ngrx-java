package com.ngrx.course.ngrx_backend.Service;

import com.ngrx.course.ngrx_backend.Entity.Lesson;
import com.ngrx.course.ngrx_backend.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public List<Lesson> findByCourseId(Long courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }
}


