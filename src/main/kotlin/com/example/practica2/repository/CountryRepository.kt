package com.example.invoice.repository

import com.example.invoice.entity.Country
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository:JpaRepository<Country, Long?> {

}