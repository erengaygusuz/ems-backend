package tr.com.erengaygusuz.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.erengaygusuz.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
