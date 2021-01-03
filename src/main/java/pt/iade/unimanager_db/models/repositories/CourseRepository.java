package pt.iade.unimanager_db.models.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.unimanager_db.models.Course;
import pt.iade.unimanager_db.models.Plan;

public interface CourseRepository extends CrudRepository<Course, Integer>{
    @Modifying
    @Transactional
    @Query(value="Insert into studyplans "+ "(pla_cour_id,pla_sub_id,pla_semester) "+ 
    "values(:#{#plan.course.id}, "+
    "values(:#{#plan.unit.id},:#{#plan.semester})", nativeQuery = true)

    void addUnitToCourse(@Param("plan") Plan plan);
}
