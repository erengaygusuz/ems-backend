package tr.com.erengaygusuz.ems.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.erengaygusuz.ems.dto.DepartmentDto;
import tr.com.erengaygusuz.ems.entity.Department;
import tr.com.erengaygusuz.ems.mapper.DepartmentMapper;
import tr.com.erengaygusuz.ems.repository.DepartmentRepository;
import tr.com.erengaygusuz.ems.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
