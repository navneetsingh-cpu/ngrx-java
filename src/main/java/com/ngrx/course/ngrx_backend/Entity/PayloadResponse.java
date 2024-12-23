package com.ngrx.course.ngrx_backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PayloadResponse<T> {
    private boolean success;
    private String message;
    private T payload;
}
