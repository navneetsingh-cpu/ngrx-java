package com.ngrx.course.ngrx_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractResponseDTO {
    private String message;
    private boolean succeeded;
}
