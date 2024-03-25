package tr.com.erengaygusuz.ems.service;

import tr.com.erengaygusuz.ems.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);
}
