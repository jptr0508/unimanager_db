package pt.iade.unimanager_db.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "students")

public class Student{
    @Id @GeneratedValue
    (strategy = GenerationType.IDENTITY)
    
    @Column(name="stud_id")
    private int id;

    @Column(name="stud_name")
    private String name;

    @Column(name="stud_gender")
    private char gender;

    @Column(name="stud_email")
    private String email;

    @Column(name="stud_address")
    private String address;

    @Column(name="stud_dt_enr")
    private LocalDate birthDate;

    @ManyToOne @JoinColumn(name = "cour_id")
    @JsonIgnoreProperties("plans")
    private Course course;

    @OneToMany @JoinColumn(name = "enr_stud_id")
    @JsonIgnoreProperties("")
    private List<Enrollment> enrollments;
    
    public Student(){}

    public Student(List<Enrollment> enrollments, int id, String name, char gender, String email, String address, LocalDate birthDate){
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.enrollments = new ArrayList<>();
    }

    public String getStudName(){
        return name;
    }

    public int getStudId(){
        return id;
    }

    public char getStudGender(){
        return gender;
    }

    public String getStudEmail(){
        return email;
    }

    public String getStudAddress(){
        return address;
    }

    public LocalDate getStudDtEnr(){
        return birthDate;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(){
        this.course = course;
    }

    public List<Enrollment> getEnrollments(){
        return enrollments;
    }
}