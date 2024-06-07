package com.example.invoice.service

import com.example.invoice.entity.Product
import com.example.invoice.entity.User
import com.example.invoice.repository.ProductRepository
import com.example.invoice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService{
    @Autowired
    private lateinit var userRepository: UserRepository

    fun list (): List<User>{
        return userRepository.findAll()
    }
    fun getById(id: Long) : User {
        return userRepository.findById(id).orElseThrow{ RuntimeException("user not found!") }
    }
    fun save (user: User): User {
        return userRepository.save(user)
    }
    fun update(id: Long, user: User): User {
        val existingUser = userRepository.findById(id).orElseThrow { RuntimeException("user not found") }
        existingUser.fullname = user.fullname
        existingUser.email = user.email
        existingUser.gender = user.gender
        existingUser.date_of_birth = user.date_of_birth
        existingUser.create_at = user.create_at
        existingUser.country_id = user.country_id
        return userRepository.save(existingUser)
    }
    fun delete(id:Long){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id)
        }else{
            throw RuntimeException("user not found")
        }
    }
}