package homework2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final List<Student> students;

    @Autowired
    public GroupController(List<Student> students) {
        this.students = students;
    }

    @GetMapping("/{groupName}/student")
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        return Student.getByGroup(students, groupName);
    }
}
