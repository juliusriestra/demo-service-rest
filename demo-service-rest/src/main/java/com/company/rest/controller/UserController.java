package com.company.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.rest.entity.User;
import com.company.rest.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@RequestMapping("/")
//	public String index() {
//		return "Welcome Spring Boot";
//	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getAll() {
		return  ResponseEntity.ok().body(userService.getAllUsers());
	}
	
	@GetMapping("/users/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
	    User user = userService.getUserById(id);
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(user);
	}
	
//	@GetMapping("/users/name/{name}")
//	public ResponseEntity<List<User>> getUserByName(@PathVariable(value="name") String name) {
//			List<User> users = userService.findByUserName(name);
//			if (users == null) {
//				return ResponseEntity.notFound().build();
//			}
//			return ResponseEntity.ok().body(users);
//	}
//
//	@PutMapping("/users/update/{id}")
//	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody User inUser) {
//		inUser.setId(id);
//		User user = userService.updateUser(inUser);
//	    if(user == null) {
//	        return ResponseEntity.ok().body(new String("Not Found"));
//	    }
//	    return ResponseEntity.ok().body(user);
//	}
//	
//	@DeleteMapping("/users/delete/{id}")
//	public ResponseEntity<Object> deleteUser(@PathVariable(value ="id") Long id) {		
//		int  user = userService.deleteUser(id);
//	    if(user<=0) {
//	        return ResponseEntity.ok().body(new String("Not Found"));
//	    }
//	    return ResponseEntity.ok().body(new String("Deleted SuccessFully"));
//	}
}

