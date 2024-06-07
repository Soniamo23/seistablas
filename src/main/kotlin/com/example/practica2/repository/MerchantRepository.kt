package com.example.invoice.repository

import com.example.invoice.entity.Merchant
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository:JpaRepository<Merchant, Long?> {

}