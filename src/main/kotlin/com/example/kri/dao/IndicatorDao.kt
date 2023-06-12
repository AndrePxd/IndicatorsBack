package com.example.kri.dao

import javax.persistence.*

@Entity
@Table(name = "indicator")
class IndicatorDao() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idkri")
    var idKri: Long = 0

    @Column(name = "namekri", nullable = false)
    var nameKri: String = ""

    @Column(name = "value1")
    var value1: Double = 0.0

    @Column(name = "value2")
    var value2: Double = 0.0

    constructor(nameKri: String, value1: Double, value2: Double) : this() {
        this.nameKri = nameKri
        this.value1 = value1
        this.value2 = value2
    }
}
