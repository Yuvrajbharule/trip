package com.trip.trip.controller;


import com.trip.trip.payload.authPayload.UserRequestDto;
import com.trip.trip.payload.authPayload.UserResponse;
import com.trip.trip.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> userSignUp(@RequestBody UserRequestDto dto)
    {
        UserResponse responsedto = userService.createUser(dto);
        if(responsedto == null)
        {
            return new ResponseEntity<>("Useralready exist pls login", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User created",HttpStatus.CREATED);
    }

}
