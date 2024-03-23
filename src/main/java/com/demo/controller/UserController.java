package com.demo.controller;


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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService  userService;

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody User userdata){
        return ResponseEntity.ok().body(this.userService.createUser(userdata));
    }

    @GetMapping("/getList")
    public String getUser(){
        return "User List";
    }

    @PutMapping("/update")
    public String updateUser(){
        return "Update Users";
    }
    @DeleteMapping("/delete")
    public String delete(){
        return "Delete Users";
    }

    @GetMapping("/getUserById/{id}")
    public String getUserById(@PathVariable(value = "id") String id){
        return "User Name: "+ id;
    }

}
