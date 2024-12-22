package com.ngrx.course.ngrx_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponseDTO extends AbstractResponseDTO {
    private String jwt;

    public AuthenticationResponseDTO(String message, boolean succeeded, String jwt) {
        super(message, succeeded);
        this.jwt = jwt;
    }
}
