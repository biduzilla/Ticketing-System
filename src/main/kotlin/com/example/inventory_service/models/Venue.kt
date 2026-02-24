package com.example.inventory_service.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "venue")
data class Venue(
    @Id
    @Column(name = "id")
    var id: Long = 0L,
    @Column(name = "name")
    var name: String = "",
    @Column(name = "address")
    var address: String = "",
    @Column(name = "total_capacity")
    var totalCapacity: Long = 0L,
)
