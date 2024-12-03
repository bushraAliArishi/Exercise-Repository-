package com.example.exercise_repository.Controller;

import com.example.exercise_repository.ApiResponse.ApiResponse;
import com.example.exercise_repository.Model.User;
import com.example.exercise_repository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/display")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.findAllUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user has been  added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("user has been updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity updatUser(@PathVariable Integer id){

        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user has been deleted"));
    }
    @GetMapping("/login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username,@PathVariable String password){
        userService.checkUserInfo(username,password);
        return ResponseEntity.status(200).body("log in");
    }
    @GetMapping("/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/role/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role) {

        return ResponseEntity.status(200).body(userService.getUsersByRole(role));
    }
    @GetMapping("/age/{age}")
    public ResponseEntity getUsersByAge(@PathVariable Integer age) {

        return ResponseEntity.status(200).body(userService.getUsersByAge(age));
    }




}
