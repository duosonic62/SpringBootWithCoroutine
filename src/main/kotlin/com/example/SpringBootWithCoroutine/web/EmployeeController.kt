package com.example.SpringBootWithCoroutine.web

import com.example.SpringBootWithCoroutine.domain.entity.Employee
import com.example.SpringBootWithCoroutine.domain.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class EmployeeController (private val employeeService: EmployeeService) {
    @GetMapping
    suspend fun getAllEmproyee(): List<Employee> =
            employeeService.getAllEmployee()
}