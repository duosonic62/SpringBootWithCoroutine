package com.example.SpringBootWithCoroutine.repository

import com.example.SpringBootWithCoroutine.domain.entity.Employee
import com.example.SpringBootWithCoroutine.repository.infrastructure.RetrofitBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import retrofit2.Response

@Repository
class EmployeeRepository (private val employeeApi: EmployeeApi) {
    @Autowired
    constructor(): this(RetrofitBuilder.buildRetrofit().create(EmployeeApi::class.java))

    suspend fun getAllEmployee(): Response<List<Employee>> =
            employeeApi.getEmployeesWithResponse()
}