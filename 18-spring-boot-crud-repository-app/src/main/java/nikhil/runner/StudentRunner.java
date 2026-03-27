package nikhil.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.dao.IStudentDao;
import nikhil.entity.Student;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private IStudentDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(dao.getClass().getName());
		
		//save operation
		dao.save(new Student(1,"Nikhil","Hayatpur",19));
		
		Student s1 = new Student(2, "sachin", "rewari", 20);
		Student s2 = new Student(3, "kunal", "hayatpur", 19);
		Student s3 = new Student(4, "kartik", "hayatpur", 18);
		dao.saveAll(List.of(s1, s2, s3)).forEach(System.out::println);

	}

}
