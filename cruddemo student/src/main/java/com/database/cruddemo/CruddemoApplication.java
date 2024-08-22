package com.database.cruddemo;

import com.database.cruddemo.dao.StudentDAO;
import com.database.cruddemo.entity.Student;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{

			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//createStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteStudentAll(studentDAO);
		};


	}

	private void deleteStudentAll(StudentDAO studentDAO) {
		System.out.println("Deleting all student");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Getting student with ıd: "+studentId);
		Student myStudent = studentDAO.findByID(studentId);
		myStudent.setFirstName("Scobby");
		studentDAO.update(myStudent);
		System.out.println("Updating student... ");
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findByLastName("Bosh");
		for (Student tempStudents : theStudents){
			System.out.println(theStudents);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}

	}

	;//CommandLineRunner arayüzü, uygulama başlatıldığında çalıştırılacak olan bir run metodunu içerir.




	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new studen object... ");
		Student tempstuden4=new Student("Jack","Bosh","bosh@gmail.com");
		studentDAO.save(tempstuden4);
		int theId= tempstuden4.getId();
		System.out.println("Saved student. Generate Id: "+theId);
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent =studentDAO.findByID(theId);
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student 2object...");
		Student tempStudent1 = new Student("John","Doe","john@gmail.com");
		Student tempStudent2 = new Student("Hanry","Do","Hanry@gmail.com");
		Student tempStudent3 = new Student("Bob","Carry","Bobl@gmail.com");

		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Doe","paul@gmail.com");
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);
		System.out.println("Saved student.Generated id: "+tempStudent.getId());
	}
}