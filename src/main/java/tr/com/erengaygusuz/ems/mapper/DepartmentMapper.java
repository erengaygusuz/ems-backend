package tr.com.erengaygusuz.ems.mapper;

import tr.com.erengaygusuz.ems.dto.DepartmentDto;
import tr.com.erengaygusuz.ems.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDescription()
        );
    }
}
