package com.example.inventory_service.repository

import com.example.inventory_service.models.Venue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VenueRepository : JpaRepository<Venue, Long> {
}