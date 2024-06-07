package com.example.invoice.service

import com.example.invoice.entity.Merchant
import com.example.invoice.entity.Product
import com.example.invoice.repository.MerchantRepository
import com.example.invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MerchantService{
    @Autowired
    private lateinit var merchantRepository: MerchantRepository

    fun list (): List<Merchant>{
        return merchantRepository.findAll()
    }
    fun getById(id: Long) : Merchant {
        return merchantRepository.findById(id).orElseThrow{ RuntimeException("merchant not found!") }
    }
    fun save (merchant: Merchant): Merchant {
        return merchantRepository.save(merchant)
    }
    fun update(id: Long, merchant: Merchant): Merchant {
        val existingMerchant = merchantRepository.findById(id).orElseThrow { RuntimeException("merchant not found") }
        existingMerchant.merchant_name = merchant.merchant_name
        existingMerchant.create_at = merchant.create_at
        existingMerchant.admin_id = merchant.admin_id
        existingMerchant.country_id = merchant.country_id
        return merchantRepository.save(existingMerchant)
    }
    fun delete(id:Long){
        if (merchantRepository.existsById(id)){
            merchantRepository.deleteById(id)
        }else{
            throw RuntimeException("merchant not found")
        }
    }
}