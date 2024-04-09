package tr.com.erengaygusuz.ems.service.impl;

import lombok.AllArgsConstructor;
import tr.com.erengaygusuz.ems.dto.EmployeeDto;
import tr.com.erengaygusuz.ems.entity.Department;
import tr.com.erengaygusuz.ems.entity.Employee;
import tr.com.erengaygusuz.ems.exception.ResourceNotFoundException;
import tr.com.erengaygusuz.ems.mapper.EmployeeMapper;
import tr.com.erengaygusuz.ems.repository.DepartmentRepository;
import tr.com.erengaygusuz.ems.repository.EmployeeRepository;
import tr.com.erengaygusuz.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department is not exists with id: " + employeeDto.getDepartmentId()));
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department is not exists with id: " + employeeDto.getDepartmentId()));
        employee.setDepartment(department);

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        employeeRepository.delete(employee);
    }
}
