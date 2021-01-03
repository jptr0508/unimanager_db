package pt.iade.unimanager_db.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "enrollments")

public class Enrollment {
    @Id @GeneratedValue
    (strategy = GenerationType.IDENTITY)

    @Column(name = "enr_id")
    private int id;

    @Column(name = "enr_stud_id")
    @JsonIgnore
    private int studId;

    @Column(name = "enr_pla_cour_id")
    @JsonIgnore
    private int courseId;

    @Column(name = "enr_pla_sub_id")
    private int unitId;

    @Column(name = "enr_dt_enrollment")
    private LocalDate enrollDay;

    @Column(name = "enr_dt_grading")
    private LocalDate gradeDay;

    @Column(name = "enr_dt_grade")
    private double grade;

    @ManyToOne @MapsId("studId") @JoinColumn(name = "enr_stud_id")
    @JsonIgnoreProperties("enrollment")
    private Student student;

    @ManyToOne @MapsId("courseId") @JoinColumn(name = "enr_pla_cour_id")
    @JsonIgnoreProperties("plans")
    private Course course;

    public Enrollment(){}

    public Enrollment(int id, double grade, LocalDate gradeDay, LocalDate enrollDay, Student Student, Course course, int unitId) {
        this.id = id;
        this.grade = grade;
        this.gradeDay = gradeDay;
        this.student = student;
        this.course = course;
        this.unitId = unitId;
        this.enrollDay = enrollDay;
    }

    public int getId(){
        return id;
    }

    public double getGrade(){
        return grade;
    }

    public void setGrade(){
        this.grade = grade;
    }

    public LocalDate getGradeDay(){
        return gradeDay;
    }

    public void setGradeDay(){
        this.gradeDay = gradeDay;
    }

    public Student getStudent(){
        return student;
    }

    public Course getCourse(){
        return course;
    }

    public int getUnitId(){
        return unitId;
    }

    public LocalDate getEnrollDay(){
        return enrollDay;
    }

    public void setEnrollDay(){
        this.enrollDay = enrollDay;
    }
}