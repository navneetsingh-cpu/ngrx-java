package com.ngrx.course.ngrx_backend.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {

    @Id
    private Long id;
    private String description;
    private String longDescription;
    private String iconUrl;
    private int lessonsCount;
    private String category;
    private int seqNo;
    private String url;
    private String promo;

}
