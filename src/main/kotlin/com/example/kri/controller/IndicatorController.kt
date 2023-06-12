package com.example.kri.controller

import com.example.kri.dao.IndicatorDao
import com.example.kri.dao.repository.IndicatorRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/indicators")

class IndicatorController(private val repository: IndicatorRepository) {

    @GetMapping
    fun getAll() = repository.findAll()

    @PostMapping
    fun create(@RequestBody indicator: IndicatorDao) = repository.save(indicator)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody indicator: IndicatorDao): ResponseEntity<IndicatorDao> {
        return repository.findById(id).map { existingIndicator ->
            existingIndicator.nameKri = indicator.nameKri
            existingIndicator.value1 = indicator.value1
            existingIndicator.value2 = indicator.value2
            ResponseEntity.ok(repository.save(existingIndicator))
        }.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Indicator not found") }
    }



    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = repository.deleteById(id)

    @GetMapping("/{id}")
    fun getIndicator(@PathVariable id: Long): ResponseEntity<IndicatorDao> {
        return repository.findById(id)
            .map { indicator -> ResponseEntity.ok(indicator) }
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Indicator not found") }
    }

}
