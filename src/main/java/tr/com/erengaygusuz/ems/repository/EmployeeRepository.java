package tr.com.erengaygusuz.ems.repository;

import tr.com.erengaygusuz.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
