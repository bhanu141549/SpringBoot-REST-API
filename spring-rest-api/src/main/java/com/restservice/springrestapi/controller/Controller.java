package com.restservice.springrestapi.controller;

import com.restservice.springrestapi.model.RestUser;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class Controller {

    Map<String, RestUser> allUsers = new HashMap<>();

    @GetMapping
    public Collection<RestUser> getMethod(){
        return allUsers.values();
    }

    @PostMapping
    public String postMethod(@RequestBody RestUser userDetails){
        RestUser addValue = new RestUser();
        addValue.setUserId(userDetails.getUserId());
        addValue.setName(userDetails.getName());
        addValue.setEmail(userDetails.getEmail());
        allUsers.put(userDetails.getUserId(),addValue);
        return "user added";
    }

    @PutMapping(path = "/{userId}")
    public String putMethod(@PathVariable String userId, @RequestBody RestUser userDetails){
        if (allUsers.containsKey(userId)){
            RestUser addValue = new RestUser();
            addValue.setUserId(userDetails.getUserId());
            addValue.setName(userDetails.getName());
            addValue.setEmail(userDetails.getEmail());
            allUsers.put(userId,addValue);
            return "Edit is done";
        }
        else {
            return "user Not found";
        }
    }

    @DeleteMapping(path = "/{userId}")
    public String deleteMethod(@PathVariable String userId){
        if (allUsers.containsKey(userId)){
            allUsers.remove(userId);
            return "user Deleted Successfully";
        }
        else{
            return "userId not found";
        }
    }
}