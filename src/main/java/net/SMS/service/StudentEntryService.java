package net.SMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.SMS.Entry.StudentEntry;
import net.SMS.repository.StudentEntryRepo;

@Component
public class StudentEntryService {

	@Autowired
	private StudentEntryRepo studentEntryRepo;
	//POST
	public void saveEntry(StudentEntry studentEntry) {
		studentEntryRepo.save(studentEntry);
	}
	//get all
	public List<StudentEntry>getAll(){
		return studentEntryRepo.findAll();
	}
	//get by ID
	public Optional<StudentEntry> findById(long id) {
		return studentEntryRepo.findById(id);
	}
	//DELETE by Id
	public void deleteById(long id) {
		studentEntryRepo.deleteById(id);
	}
}
