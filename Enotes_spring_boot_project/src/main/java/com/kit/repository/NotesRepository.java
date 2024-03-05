package com.kit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kit.entity.Notes;
import com.kit.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer>{
	
	public List<Notes> findByUser(User user);

}
