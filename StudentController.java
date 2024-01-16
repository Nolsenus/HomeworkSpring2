package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> students;

    @Autowired
    public StudentController(List<Student> students) {
        this.students = students;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable long id) {
        return Student.getByID(students, id);
    }

    @GetMapping("/search")
    public List<Student> getStudentsByNameContains(@RequestParam String name) {
        return Student.getByNameContains(students, name);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student postStudent(@RequestBody Student student) {
        Student.addStudent(students, student);
        return student;
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable long id) {
        return Student.removeStudentByID(students, id);
    }



}
