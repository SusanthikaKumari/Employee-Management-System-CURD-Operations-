package com.susanthika.employeems.service;

import com.susanthika.employeems.dto.EmployeeDTO;
import com.susanthika.employeems.entity.Employee;
import com.susanthika.employeems.repo.EmployeeRepo;
import com.susanthika.employeems.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;   // JpaRepository methods used krnn ona nisa EmployeeRepo ek inject krgnnw, employeeRepo is variable

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO){
        if (employeeRepo.existsById(employeeDTO.getEmpID())){
            return VarList.RSP_DUPLICATED;
        }else{
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
