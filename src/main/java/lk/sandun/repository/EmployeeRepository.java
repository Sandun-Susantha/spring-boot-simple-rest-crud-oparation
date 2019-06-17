package lk.sandun.repository;

import lk.sandun.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Pirasanth on 6/4/2019.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    /*@Modifying
    @Query("delete from employee b where b.id=:id")
    void deleteEmployee(@Param("id") String title);*/
}
