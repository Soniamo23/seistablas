package com.example.invoice.repository

import com.example.invoice.entity.Order
import com.example.invoice.entity.Order_item
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface Order_itemRepository:JpaRepository<Order_item, Long?> {

}