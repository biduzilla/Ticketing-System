package com.example.inventory_service.service

import com.example.inventory_service.dto.EventInventoryDTO
import com.example.inventory_service.dto.VenueInventoryDTO
import com.example.inventory_service.repository.EventRepository
import com.example.inventory_service.repository.VenueRepository
import com.example.user_service.utils.logger
import org.springframework.stereotype.Service

@Service
class InventoryService(
    private val eventRepository: EventRepository,
    private val venueRepository: VenueRepository
) {
    companion object {
        val log = logger()
    }

    fun getAllEvents(): List<EventInventoryDTO> {
        val events = eventRepository.findAll()
        return events.map { event ->
            EventInventoryDTO(
                event = event.name,
                capacity = event.leftCapacity,
                venue = event.venue
            )
        }.toList()
    }

    fun getVenueInformation(venueId: Long): VenueInventoryDTO {
        val venue = venueRepository.findById(venueId).orElse(null)

        return VenueInventoryDTO(
            venueId,
            venue.name,
            venue.totalCapacity
        )
    }

    fun getEventInventory(eventId: Long): EventInventoryDTO {
        val event = eventRepository.findById(eventId).orElse(null)

        return EventInventoryDTO(
            event = event.name,
            capacity = event.leftCapacity,
            venue = event.venue,
            ticketPrice = event.ticketPrice,
            eventId = eventId
        )
    }

    fun updateEventCapacity(eventId: Long, ticketsBooked: Long) {
        val event = eventRepository.findById(eventId).orElse(null)
        event.leftCapacity -= ticketsBooked
        eventRepository.saveAndFlush(event)
        log.info("Updated event capacity for event id: {} with tickets booked: {}", eventId, ticketsBooked)
    }
}