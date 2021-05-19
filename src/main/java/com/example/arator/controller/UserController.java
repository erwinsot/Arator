package com.example.arator.controller;

import com.example.arator.entity.User;
import com.example.arator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //Crea nuevo usuario
    @PostMapping
    public ResponseEntity<?>create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<User> oUser=userService.findById(id);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }
}
