package pt.iade.unimanager_db.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimanager_db.models.Departments;

public interface DepartmentRepository extends CrudRepository<Departments, Integer>{
    
}
