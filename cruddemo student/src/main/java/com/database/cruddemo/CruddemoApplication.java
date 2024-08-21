package com.database.cruddemo;

import com.database.cruddemo.dao.StudentDAO;
import com.database.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
<<<<<<< HEAD
		//createMultipleStudent(studentDAO);
		readStudent(studentDAO);
		};
=======
		createStudent(studentDAO);
		};//CommandLineRunner arayüzü, uygulama başlatıldığında çalıştırılacak olan bir run metodunu içerir.
	
>>>>>>> c2816bc4aaede8e0c0b963a9652694db53307c3c
	}

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
