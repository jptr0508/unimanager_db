package pt.iade.unimanager_db.models;

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
@Table(name = "subjects")

public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="sub_id")
    private int id;

    @Column(name="sub_name")
    private String name;

    @Column(name="sub_credits")
    private int credits;

    @OneToMany @JoinColumn(name="pla_sub_id")
    @JsonIgnoreProperties("unit")
    private List<Plan> plans;

    @ManyToOne @JoinColumn(name = "sub_dep_id")
    private Departments department;
    
    public Unit(){}

    public Unit(int id, int credits, String name, List<Plan> plans, Departments department){
        this.credits = credits;
        this.name = name;
        this.id = id;
        this.plans = new ArrayList<>();
        this.department = department;
    }

    public String getSubName(){
        return name;
    }

    public int getSubCredits(){
        return credits;
    }

    public int getSubId(){
        return id;
    }

    public List<Plan> getPlan(){
        return plans;
    }

    public  Departments getDepartment(){
        return department;
    }
}
