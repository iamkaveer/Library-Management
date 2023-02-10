package com.librarymodel.LibraryModel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.librarymodel.LibraryModel.model.Library;

@Service
public class LibraryService {
	
	private static final List<Library> library = new ArrayList<>();
	
	static {
		Library l1 = new Library("Local","Agartala","9874562","Wifi available");
		library.add(l1);
		
		Library l2 = new Library("Central","Tripura","3265874","Wifi, AC, Snacks");
		library.add(l2);
		
		Library l3 = new Library("Hostel","ICFAI","7856413","Takeout");
		library.add(l3);
	}
	
	//get all library
	public List<Library> getAll(){
		return library;
	}
	
	//get by name
	public Library getByName(String name) {
		//return restaurants.stream().filter(t -> t.getRestaurants_name().equals(name)).findFirst().get();
		return library.stream().filter(t -> t.getLibraryName().equals(name)).findFirst().get();
	}
	
	//create a Library
	public Library addLibrary(Library lib){
		library.add(lib);
		return lib;
	}
	
	//delete Library by name
	public void deleteLibrary(String name) {
		library.removeIf(t -> t.getLibraryName().equals(name));
	}
	

}
