package com.example.SpringBootWithCoroutine.repository

import com.example.SpringBootWithCoroutine.domain.entity.Employee
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeApi  {
    @GET("employees")
    suspend fun getEmployeesWithResponse(): Response<List<Employee>>
}