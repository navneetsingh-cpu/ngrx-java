package com.ngrx.course.ngrx_backend.Repository;

import com.ngrx.course.ngrx_backend.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByCourseId(Integer courseId);
}
