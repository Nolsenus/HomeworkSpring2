package homework2;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.List;

@Data
public class Student {

    private final long id;
    private final String name;
    private final String groupName;

    @JsonCreator
    public Student(long id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    public static List<Student> getByNameContains(List<Student> students, String toSearch) {
        return students.stream()
                .filter(it -> it.name.contains(toSearch))
                .toList();
    }

    public static Student getByID(List<Student> students, long id) {
        return students.stream()
                .filter(it -> it.id == id)
                .findFirst()
                .orElse(null);
    }

    public static List<Student> getByGroup(List<Student> students, String groupName) {
        return students.stream()
                .filter(it -> it.groupName.equals(groupName))
                .toList();
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static boolean removeStudentByID(List<Student> students, long id) {
        return students.removeIf(student -> student.id == id);
    }
}
