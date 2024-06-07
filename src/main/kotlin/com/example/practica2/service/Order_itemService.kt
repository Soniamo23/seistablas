package com.example.invoice.service

import com.example.invoice.entity.Order_item
import com.example.invoice.entity.Product
import com.example.invoice.repository.Order_itemRepository
import com.example.invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Order_itemService{
    @Autowired
    private lateinit var order_itemRepository: Order_itemRepository

    fun list (): List<Order_item>{
        return order_itemRepository.findAll()
    }
    fun getById(id: Long) : Order_item {
        return order_itemRepository.findById(id).orElseThrow{ RuntimeException("order_item not found!") }
    }
    fun save (order_item: Order_item): Order_item {
        return order_itemRepository.save(order_item)
    }
    fun update(id: Long, order_item: Order_item): Order_item {
        val existingOrder_item = order_itemRepository.findById(id).orElseThrow { RuntimeException("order_item not found") }
        existingOrder_item.quantity = order_item.quantity
        existingOrder_item.orderId = order_item.orderId
        existingOrder_item.productId = order_item.productId
        return order_itemRepository.save(existingOrder_item)
    }
    fun delete(id:Long){
        if (order_itemRepository.existsById(id)){
            order_itemRepository.deleteById(id)
        }else{
            throw RuntimeException("order_item not found")
        }
    }
}