package pt.iade.unimanager_db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pt.iade.unimanager_db.models.id.PlanId;

@Entity
@Table (name="studyplans")
@IdClass(PlanId.class)

public class Plan{
    @Id 
    @Column (name="pla_cour_id")
    @JsonIgnore 
    private int courseId;

    @ManyToOne @MapsId ("courseId") @JoinColumn (name="pla_cour_id")
    @JsonIgnoreProperties("plans")
    private Course course;
    
    @Column (name="pla_semester")
    private int semester;

    @Id
    @Column(name = "pla_sub_id")
    @JsonIgnore 
    private int unitId;

    @ManyToOne @MapsId("unitId") @JoinColumn(name = "pla_sub_id")
    @JsonIgnoreProperties("plans")
    private Unit unit;

    public Plan(){}

    public Plan(int courseId, int semester, Course course, int unitId, Unit unit){
        this.course = course;
        this.courseId = courseId;
        this.semester = semester;
        this.unit = unit;
        this.unitId = unitId;
    }

    public int getCourseId(){
        return courseId;
    }

    public void setCourseId(){
        this.courseId = courseId;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(){
        this.course = course;
    }

    public int getSemester(){
        return semester;
    }

    public void setSemester(){
        this.semester = semester;
    }

    public Unit getUnit(){
        return unit;
    }

    public void setUnit(){
        this.unit = unit;
    }

    public int getUnitId(){
        return unitId;
    }

    public void setUnitId(){
        this.unitId = unitId;
    }
}