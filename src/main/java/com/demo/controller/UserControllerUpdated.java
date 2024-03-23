package com.demo.controller;


import com.demo.constant.EndPoints;
import com.demo.dto.UserDTO;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(EndPoints.USERS)
public class UserControllerUpdated {

    @Autowired
    UserService  userService;

    @PostMapping(EndPoints.USERS)
    public ResponseEntity createUser(@RequestBody User userdata){
        return ResponseEntity.ok().body(this.userService.createUser(userdata));
    }

    @GetMapping(EndPoints.USERS)
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok().body(this.userService.getUserList());
    }

    @PutMapping(EndPoints.USERS+ "/{id}")
    public String updateUser(@PathVariable(value = "id") String id){
        return "Updated Users for ID:"+ id;
    }
    @DeleteMapping(EndPoints.USERS+ "/{id}")
    public void delete(@PathVariable(value = "id") String id){
        long userID= Long.parseLong(id);
        this.userService.deleteUser(userID);
    }

    @GetMapping(EndPoints.USERS + "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") String id){
        long userID= Long.parseLong(id);
        return ResponseEntity.ok().body(this.userService.getUserDetailsById(Long.valueOf(userID)));
    }

    @RequestMapping(value = EndPoints.USERS, method = RequestMethod.OPTIONS)
    public String optionsForResource() {
        return "Allowed HTTP Methods: GET, POST, DELETE, OPTIONS";
    }






}
