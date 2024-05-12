package model.response.exception.sevice;

import lombok.AllArgsConstructor;
import model.response.entity.Student;
import model.response.exception.respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student addStudent(String name, int grade) {
        Student student = new Student(name, grade);
        studentRepository.add(student);
        return student;
    }

    public List<Student> getOrderedStudent() {
        return studentRepository.getSorted();
    }

    public List<Student> getGradeStudent(int grade) {
        return studentRepository.getBy(grade);
    }
}
