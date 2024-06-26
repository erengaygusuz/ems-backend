package tr.com.erengaygusuz.ems.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.erengaygusuz.ems.dto.DepartmentDto;
import tr.com.erengaygusuz.ems.service.DepartmentService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "https://ems1.erengaygusuz.com.tr", "https://ems2.erengaygusuz.com.tr"})
@AllArgsConstructor
@RestController
@RequestMapping("/v1/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);

        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);

        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartments();

        return ResponseEntity.ok(departmentDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto departmentDto){
        DepartmentDto updatedDepartmentDto = departmentService.updateDepartment(departmentId, departmentDto);

        return  ResponseEntity.ok(updatedDepartmentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);

        return ResponseEntity.ok("Department deleted successfully!");
    }
}
