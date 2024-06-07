package com.example.invoice.controller

import com.example.invoice.entity.Country
import com.example.invoice.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
class OrderController {
    @Autowired
    lateinit var countrytService: CountryService

    @GetMapping
    fun list(): List<Country> {
        return  countrytService.list()

    }
    @GetMapping("/{id]")
    fun getById(@PathVariable id : Long): Country {
        return countrytService.getById(id)
    }
    @PostMapping
    fun save(@RequestBody  country: Country): Country {
        return countrytService.save(country)
    }
    @PutMapping("/{id]")
    fun update(@PathVariable id: Long, @RequestBody country: Country): Country {
        return countrytService.update(id, country)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):String {
        countrytService.delete(id)
        return "Country $id deleted"
    }
}
