package pt.iade.unimanager_db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "departments")

public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "dep_id")
    private int id;

    @Column(name = "dep_name")
    private String name;

    @Column(name = "dep_initials")
    private char initials;

    public Departments(){}

    public Departments(int id, String name, char initials){
        this.id = id;
        this.name = name;
        this.initials = initials;
    }

    public int getId(){
        return id;
    }

    public String getname(){
        return name;
    }

    public char getInitials(){
        return initials;
    }
}
