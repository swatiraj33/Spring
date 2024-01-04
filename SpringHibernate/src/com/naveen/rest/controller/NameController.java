package com.naveen.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.rest.model.Name;
import com.naveen.rest.service.NameService;


@RestController
@RequestMapping("/rest")
public class NameController {

	@Autowired
	NameService nameservice;
	
	//get a particular name
	@GetMapping(value="/name/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Name getNameByID(@PathVariable("id") int num){
		Name name = null;
		try{
			name = nameservice.searchSpecific(num);
		}catch(Exception e){
			e.printStackTrace();
		}
		return name;		
	}
	
	//get all names in the database
	@GetMapping(value = "/name/all", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Name> getAllNames(){
		System.out.println("Hello");
		return nameservice.displayAll();
	}
	
	//creat a record
	@PostMapping(value = "/name/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	int addEmployee(@RequestBody Name name) {
		try {
			return 	nameservice.save(name);
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//delete a specific record
	@DeleteMapping("/name/delete/{id}")
	public @ResponseBody String deleteNameByID(@PathVariable("id") int num){
		return nameservice.delete(num);
	}
}
