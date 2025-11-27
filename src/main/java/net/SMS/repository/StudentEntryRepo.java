package net.SMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.SMS.Entry.StudentEntry;

public interface StudentEntryRepo extends JpaRepository<StudentEntry, Long> {

}
