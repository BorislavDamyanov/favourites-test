package favouritetest.demo.controller;


import favouritetest.demo.entity.User;
import favouritetest.demo.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/users")
    public List<User>  retrieveAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody User user){
        User savedUser = userService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}

