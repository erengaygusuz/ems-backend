package tr.com.erengaygusuz.ems.controller;

import lombok.AllArgsConstructor;
import tr.com.erengaygusuz.ems.dto.EmployeeDto;
import tr.com.erengaygusuz.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "https://ems1.erengaygusuz.com.tr", "https://ems2.erengaygusuz.com.tr"})
@AllArgsConstructor
@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long employeeId)
    {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();

        return ResponseEntity.ok(employeeDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeId, employeeDto);

        return ResponseEntity.ok(updatedEmployeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}
