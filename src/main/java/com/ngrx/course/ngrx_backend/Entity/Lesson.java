package com.ngrx.course.ngrx_backend.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Lesson {


    @Id
    private Integer id;
    private String description;
    private String duration;
    private int seqNo;
    private Long courseId;


}
