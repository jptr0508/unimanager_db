package pt.iade.unimanager_db.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.unimanager_db.models.Unit;
import pt.iade.unimanager_db.models.views.UnitPlanView;

public interface UnitRepository extends CrudRepository<Unit, Integer>{
    Iterable<Unit> findByName(String name);
    Iterable<Unit> findByNameLike(String name);
    Iterable<Unit> findByCreditsBetween(int min, int max);
    Iterable<Unit> findByNameLikeAndByCreditsBetween(int min, int max, String name);

    String QueryFindUnitPlans = "Select u.sub_id AS id, u.sub_name AS name, "+
    "u.sub_credits AS credits, "+
    "p.pla_semester AS semester, "+
    "c.cour_name AS courseName, c.cour_id AS courseId "+
    "FROM subjects u"+
    "INNER JOIN studyplans p ON u.sub_id=p.pla_sub_id "+
    "INNER JOIN courses c ON p.pla_cour_id=c.cour_id";

    @Query(value=QueryFindUnitPlans, nativeQuery = true)
    Iterable<UnitPlanView> findAllUnitPlans();

    @Query(value=QueryFindUnitPlans + "Where u.sub_id=:id", nativeQuery = true)
    Iterable<UnitPlanView> findAllUnitPlansById(@Param("id") int id);

    @Query(value=QueryFindUnitPlans + "Where u.sub_id=:idUnit and c.cour_id=:idCourse", nativeQuery = true)
    Optional<UnitPlanView> findAllUnitPlansByUnitAndCourse(@Param("idUnit") int idunit, @Param("idCourse") int idCourse);
}


