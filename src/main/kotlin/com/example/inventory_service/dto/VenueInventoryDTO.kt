package com.example.inventory_service.dto

data class VenueInventoryDTO(
    var venueId: Long = 0L,
    var venueName: String = "",
    var totalCapacity: Long = 0L,
)
