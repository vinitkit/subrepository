package com.kit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.exception.StudentAlreadyExistsException;
import com.kit.exception.StudentNotFoundException;
import com.kit.model.Student;
import com.kit.repository.StudentRepository;
@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		
		if(studentAlreadyExists(student.getEmail())) {
			throw new StudentAlreadyExistsException(student.getEmail()+"Already Exists!");
		}
		
		return studentRepository.save(student);
	}

	

	@Override
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		
		return studentRepository.findById(id).map(st->{
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return studentRepository.save(st);
		}).orElseThrow(()->new StudentNotFoundException("student does not exists"));
	}

	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id)
				.orElseThrow(()-> new StudentNotFoundException("Sorry no student found with the id : " + id));
	}

	@Override
	public void deleteStudent(Long id) {
		 if (!studentRepository.existsById(id)){
	            throw new StudentNotFoundException("Sorry, student not found");
	        }
	        studentRepository.deleteById(id);
		
	}
	
	private boolean studentAlreadyExists(String email) {
		
		return studentRepository.findByEmail(email).isPresent();
	}

}
