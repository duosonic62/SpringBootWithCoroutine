package com.example.SpringBootWithCoroutine.domain.service

import com.example.SpringBootWithCoroutine.domain.entity.Employee
import com.example.SpringBootWithCoroutine.repository.EmployeeRepository
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service

@Service
class EmployeeService (private val employeeRepository: EmployeeRepository) {

    suspend fun getAllEmployee(): List<Employee> = coroutineScope {
        employeeRepository.getAllEmployee().body() ?: throw Exception()
    }

}