package com.example.SpringBootWithCoroutine.domain.entity

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Employee @JsonCreator constructor(
        @Json(name = "id")
        @JsonProperty("id")
        val id: Int,

        @Json(name = "employee_name")
        @JsonProperty("employee_name")
        val employee_name: String? = null,

        @Json(name = "employee_salary")
        @JsonProperty("employee_salary")
        val employee_salary: String? = null,

        @Json(name = "employee_age")
        @JsonProperty("employee_age")
        val employee_age: Int? = null,

        @Json(name = "profile_image")
        @JsonProperty("profile_image")
        val profile_image: String? = null
)