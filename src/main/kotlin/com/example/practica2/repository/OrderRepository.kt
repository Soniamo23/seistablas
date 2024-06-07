package com.example.invoice.repository

import com.example.invoice.entity.Order
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository:JpaRepository<Order, Long?> {

}