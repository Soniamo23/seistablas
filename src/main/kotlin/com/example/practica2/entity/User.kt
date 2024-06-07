package com.example.invoice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user" )
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fullname: String? = null
    var email: String? = null
    var gender: String? = null
    var date_of_birth: Double? = null
    var create_at: String? = null
    var country_id: String? = null
}