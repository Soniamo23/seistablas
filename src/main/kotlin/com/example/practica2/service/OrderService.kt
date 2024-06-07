package com.example.invoice.service

import com.example.invoice.entity.Order
import com.example.invoice.entity.Product
import com.example.invoice.repository.OrderRepository
import com.example.invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService{
    @Autowired
    private lateinit var orderRepository: OrderRepository

    fun list (): List<Order>{
        return orderRepository.findAll()
    }
    fun getById(id: Long) : Order {
        return orderRepository.findById(id).orElseThrow{ RuntimeException("order not found!") }
    }
    fun save (order: Order): Order {
        return orderRepository.save(order)
    }
    fun update(id: Long, order: Order): Order {
        val existingOrder = orderRepository.findById(id).orElseThrow { RuntimeException("order not found") }
        existingOrder.status= order.status
        existingOrder.create_at = order.create_at
        existingOrder.user_id = order.user_id
        return orderRepository.save(existingOrder)
    }
    fun delete(id:Long){
        if (orderRepository.existsById(id)){
            orderRepository.deleteById(id)
        }else{
            throw RuntimeException("order not found")
        }
    }
}