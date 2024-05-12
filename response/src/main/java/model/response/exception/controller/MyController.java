package model.response.exception.controller;

import lombok.AllArgsConstructor;
import model.response.ApiResponse;
import model.response.entity.Student;
import model.response.exception.CustomException;
import model.response.exception.ErrorCode;
import model.response.exception.data.InputRestriction;
import model.response.exception.sevice.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MyController extends BaseController {

    private final StudentService studentService;

    @GetMapping("/student/{name}/{grade}")
    public ApiResponse<Student> add(
            @PathVariable String name,
            @PathVariable int grade
    ) {
        if (grade > 5) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "grade는 6이상 입력할 수 없습니다.", new InputRestriction(5));
        }

        Student student = studentService.addStudent(name, grade);
        return makeApiResponse(student);
    }

    @GetMapping("/student/ordered")
    public ApiResponse<Student> getOrdered() {
        List<Student> students = studentService.getOrderedStudent();
        return makeApiResponse(students);
    }

    @GetMapping("/student/{grade}")
    public ApiResponse<Student> getSameGrade(
            @PathVariable int grade
    ) {
        List<Student> students = studentService.getGradeStudent(grade);
        return makeApiResponse(students);
    }
}
