package tr.com.erengaygusuz.ems.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.erengaygusuz.ems.dto.DepartmentDto;
import tr.com.erengaygusuz.ems.entity.Department;
import tr.com.erengaygusuz.ems.exception.ResourceNotFoundException;
import tr.com.erengaygusuz.ems.mapper.DepartmentMapper;
import tr.com.erengaygusuz.ems.repository.DepartmentRepository;
import tr.com.erengaygusuz.ems.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Departments is nor exists with a given id: " + departmentId)
        );

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> departments =  departmentRepository.findAll();

        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Departments is nor exists with a given id: " + departmentId)
        );

        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Departments is nor exists with a given id: " + departmentId)
        );

        departmentRepository.deleteById(departmentId);
    }
}
