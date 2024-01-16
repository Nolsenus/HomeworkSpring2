package homework2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    List<Student> students() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Igor", "PhysMath"),
                new Student(2, "Oleg", "PhysMath"),
                new Student(3, "Ivan", "PhysMath"),
                new Student(4, "Anna", "PhysMath"),
                new Student(5, "Olga", "PhysMath"),
                new Student(6, "Dmitriy", "ChemTech"),
                new Student(7, "Fyodor", "ChemTech"),
                new Student(8, "Darya", "ChemTech")));
        return students;
    }
}
