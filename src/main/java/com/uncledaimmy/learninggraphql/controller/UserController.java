package com.uncledaimmy.learninggraphql.controller;

import com.uncledaimmy.learninggraphql.dto.UserDto;
import com.uncledaimmy.learninggraphql.model.User;
import com.uncledaimmy.learninggraphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) throws Exception {
        userService.addUser(userDto);
        return ResponseEntity.ok("User has been added successfully");
    }
    @QueryMapping("findUserByEmail")
    public User findUserByEmail(@Argument String email) throws Exception {
        return userService.findUserByEmail(email);
    }
    @QueryMapping("getAllUsers")
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }

}
