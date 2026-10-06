package com.techfusion.cms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.protobuf.Api;
import com.techfusion.cms.model.Student;
import com.techfusion.cms.response.ApiResponse;
import com.techfusion.cms.service.StudentService;

@Controller
@RequestMapping("/students")
@ResponseBody
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>("Students retrieved successfully", studentService.findAll()));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ApiResponse<Student>> saveStudent(@RequestBody Student student) {

		Integer studentId = studentService.save(student);

		student.setStudentId(studentId);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse<>("Student created successfully", student));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable("id") Integer id) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>("Student retrieved successfully", studentService.findById(id)));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable("id") Integer id,
			@RequestBody Student student) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>("Student updated successfully", studentService.updateStudent(id, student)));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public  ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>("Student deleted successfully"));
	}

}