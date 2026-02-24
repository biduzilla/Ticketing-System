package com.example.inventory_service.controller

import com.example.inventory_service.dto.EventInventoryDTO
import com.example.inventory_service.dto.VenueInventoryDTO
import com.example.inventory_service.service.InventoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class InventoryController(
    private val inventoryService: InventoryService
) {

    @GetMapping("/inventory/events")
    fun inventoryGetAllEvents(): List<EventInventoryDTO> {
        return inventoryService.getAllEvents()
    }

    @GetMapping("/inventory/venue/{venueId}")
    fun inventoryByVenueId(
        @PathVariable("venueId") venueId: Long
    ): VenueInventoryDTO {
        return inventoryService.getVenueInformation(venueId)
    }

    @GetMapping("/inventory/event/{eventId}")
    fun inventoryForEvent(
        @PathVariable("eventId") eventId: Long
    ): EventInventoryDTO {
        return inventoryService.getEventInventory(eventId)
    }

    @PutMapping("/inventory/event/{eventId}/capacity/{capacity}")
    fun updateEventCapacity(
        @PathVariable("eventId") eventId: Long,
        @PathVariable("capacity") ticketsBooked: Long
    ): ResponseEntity<Void> {
        inventoryService.updateEventCapacity(eventId, ticketsBooked)
        return ResponseEntity.ok().build()
    }
}