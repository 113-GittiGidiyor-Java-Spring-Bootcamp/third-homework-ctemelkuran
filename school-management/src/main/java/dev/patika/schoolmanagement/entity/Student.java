package dev.patika.schoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    // instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;

    // With regard to normalisation Hibernate creates an association table (E.g student_courses)
    // A student can attend to 0 or more
    // @ManyToMany relationships can use FetchType.LAZY
    //@JsonIgnoreProperties({"students", "instructor"})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Course> studentCourses = new ArrayList<>();

}
