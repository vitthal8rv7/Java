package com.learn.java.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.java.mysql.model.entity.Auditing;
import com.learn.java.mysql.model.entity.Student;
import com.learn.java.mysql.repository.StudentRepository;
import com.learn.java.mysql.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

//	public static Integer value = 0;
	@Override
	public void testCallbackMethods() {
		System.out.println("");
		System.out.println("");
		System.out.println("Saving student data start...");
		Student student = studentRepository.save(Student.builder().age(2).name("3").auditing(new Auditing()).build());
		System.out.println("Student data saved.");

		sleepFor1Sec();

		System.out.println("");
		System.out.println("");
		System.out.println("Updating student data start...");
		student.setAge(10);
		student.setName("new Name");
		Student student2 = studentRepository.save(student);
		System.out.println("Student data updated.");

		sleepFor1Sec();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Deleting student data start...");
		studentRepository.delete(student);
		System.out.println("Student data deleted.");
		
		studentRepository.save(student2);
	}

	private void sleepFor1Sec() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
