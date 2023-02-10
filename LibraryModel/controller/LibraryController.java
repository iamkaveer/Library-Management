package com.librarymodel.LibraryModel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarymodel.LibraryModel.model.Library;
import com.librarymodel.LibraryModel.service.LibraryService;

@RestController
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	
	//get all
	@GetMapping("/all")
	public List<Library> getALL(){
		return libraryService.getAll();
	}
	
	//get by name
	@GetMapping("/find-by-name/{name}")
	public Library findByName(@PathVariable String name) {
		return libraryService.getByName(name);
	}
	
	//add library
	@PostMapping("/add-library")
	public Library addNew(@RequestBody Library newLib) {
		Library n = libraryService.addLibrary(newLib);
		return n;
	}
	
	//delete library
	@DeleteMapping("/delete/{name}")
	public void deleteLibrary(@PathVariable String name) {
		libraryService.deleteLibrary(name);
	}

}
