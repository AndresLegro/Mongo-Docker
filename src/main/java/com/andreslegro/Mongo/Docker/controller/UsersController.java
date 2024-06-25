package com.andreslegro.Mongo.Docker.controller;

import com.andreslegro.Mongo.Docker.Documents.Users;
import com.andreslegro.Mongo.Docker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;
    @PostMapping
    public ResponseEntity<?> saveUser (@RequestBody Users user){
        try {
            return new ResponseEntity<Users>(userService.saveUser(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Users>> getUsers (){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<?> updateUser (@RequestBody Users user){
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
