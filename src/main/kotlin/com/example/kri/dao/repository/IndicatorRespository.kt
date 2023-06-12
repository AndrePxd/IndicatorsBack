package com.example.kri.dao.repository

import com.example.kri.dao.IndicatorDao
import org.springframework.data.jpa.repository.JpaRepository

interface IndicatorRepository : JpaRepository<IndicatorDao, Long>
