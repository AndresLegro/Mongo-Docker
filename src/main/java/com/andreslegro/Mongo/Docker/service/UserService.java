package com.andreslegro.Mongo.Docker.service;

import com.andreslegro.Mongo.Docker.Documents.Users;
import com.andreslegro.Mongo.Docker.repository.IUsersRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private IUsersRepository usersRepository;

    public Users saveUser(@NonNull Users user){
        return usersRepository.save(user);
    }

    public List<Users> getUsers(){
        return  usersRepository.findAll();
    }

    public void updateUser (@NonNull Users user){
        Optional<Users> optionalUser= Optional.ofNullable(usersRepository.findById(user.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found")));

        Users userToUpdate = optionalUser.get();
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());

        usersRepository.save(userToUpdate);
    }

    public void deleteUser (int id){
        Optional<Users> optionalUser = Optional.ofNullable(usersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found")));

        usersRepository.delete(optionalUser.get());
    }
}
