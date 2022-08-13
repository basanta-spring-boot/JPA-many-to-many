package com.javatechie;

import com.javatechie.entity.Course;
import com.javatechie.entity.Student;
import com.javatechie.repository.CourseRepository;
import com.javatechie.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/students")
public class ManyToManyApplication {

	private StudentRepository studentRepository;

	private CourseRepository courseRepository;

	public ManyToManyApplication(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	@PostMapping
	public Student onBoardStudentWithCourse(@RequestBody Student student){
     return studentRepository.save(student);
	}

	@GetMapping
	@Transactional
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}

	@GetMapping("/get/{id}")
	@Transactional
	public Student getStudentById(@PathVariable Long id){
		return studentRepository.findById(id).get();
	}

	@GetMapping("/find/{name}")
	public List<Student> filterStudentsByName(@PathVariable String name){
		return studentRepository.findByNameContaining(name);
	}

	@GetMapping("/course/{fee}")
	public List<Course> findCourseByPrice(@PathVariable String fee){
		return courseRepository.findByFeeLessThan(Double.parseDouble(fee));
	}

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

}
