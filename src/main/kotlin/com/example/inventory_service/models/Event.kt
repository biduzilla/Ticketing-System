package com.example.inventory_service.models

import com.example.inventory_service.dto.EventInventoryDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "event")
data class Event(
    @Id
    var id: Long = 0L,
    @Column(name = "name")
    var name: String = "",
    @Column(name = "total_capacity")
    var totalCapacity: Long = 0L,
    @Column(name = "left_capacity")
    var leftCapacity: Long = 0L,
    @ManyToOne
    @JoinColumn(name = "venue_id")
    var venue: Venue = Venue(),
    var ticketPrice: BigDecimal = BigDecimal.ZERO
)

