package com.ngrx.course.ngrx_backend.Controller;


import com.ngrx.course.ngrx_backend.dto.AuthenticationRequestDTO;
import com.ngrx.course.ngrx_backend.dto.AuthenticationResponseDTO;
import com.ngrx.course.ngrx_backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {

    AuthenticationManager authenticationManager;
    UserDetailsService userDetailsService;
    JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    @Qualifier("CourseUserDetailsService") UserDetailsService userDetailsService,
                                    JwtUtil jwtUtil) {

        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<?> getAuthenticationToken(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) throws Exception {
        System.out.println("Authentication Request: " + authenticationRequestDTO);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new AuthenticationResponseDTO("", false, "Incorrect username or password"));
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestDTO.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponseDTO("Authentication was successful", true, jwt));
    }
}
