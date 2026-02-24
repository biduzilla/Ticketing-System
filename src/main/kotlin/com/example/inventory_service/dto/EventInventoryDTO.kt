package com.example.inventory_service.dto

import com.example.inventory_service.models.Venue
import java.math.BigDecimal

data class EventInventoryDTO(
    var eventId:Long = 0,
    var event:String = "",
    var capacity:Long = 0L,
    var venue: Venue = Venue(),
    var ticketPrice: BigDecimal = BigDecimal.ZERO
)


