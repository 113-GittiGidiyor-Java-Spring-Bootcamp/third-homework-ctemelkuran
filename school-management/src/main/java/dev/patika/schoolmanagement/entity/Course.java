package dev.patika.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String courseCode;
    private String courseName;
    private int creditScore;
    // courseCode unique olsa da best practice olarak id tanımlanır
    // autogenerate sağlanmaz, string olduğu için syntax kontrolü zor olur

    @JsonIgnore
    @ManyToMany(mappedBy = "studentCourses", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    //@JsonIgnoreProperties("{instructorCourses}")
    // @JsonBackReference
    @ManyToOne
    private Instructor instructor;



}
