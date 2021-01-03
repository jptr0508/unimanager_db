package pt.iade.unimanager_db.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Enrollment;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer>{
    
}
