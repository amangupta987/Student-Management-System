package net.SMS.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.SMS.Entry.StudentEntry;
import net.SMS.service.StudentEntryService;

@RestController
@RequestMapping("/SMS")
public class StudentEntryController {
	
	@Autowired
	private StudentEntryService studentEntryService;
	
	
	
	@GetMapping
	public List<StudentEntry> getAll(){
		return studentEntryService.getAll();
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody StudentEntry myEntry) {
		studentEntryService.saveEntry(myEntry);
		return true;
	}
	
	@GetMapping("/id/{myId}")
	public StudentEntry findById(@PathVariable long myId) {
		return studentEntryService.findById(myId).orElse(null);
	}
	
	@PutMapping("id/{myId}")
	public StudentEntry updateById(@PathVariable long myId, @RequestBody StudentEntry newEntry) {
		StudentEntry old = studentEntryService.findById(myId).orElse(null);
		if(old !=null) {
			old.setName(newEntry.getName() != null && !newEntry.getName().equals("")? newEntry.getName() : old.getName());
			old.setCourse(newEntry.getCourse() !=null && !newEntry.getCourse().equals("") ? newEntry.getCourse() : old.getCourse());
		}
		
		studentEntryService.saveEntry(old);
		return old;
	}
	
	@DeleteMapping("id/{myId}")
	public boolean deleteById(@PathVariable long myId) {
		 studentEntryService.deleteById(myId);
		 return true;
	}
}
