package com.example.inventory_service.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun inventoryServiceApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Inventory Service API")
                    .description("Inventory Service API for LeetJourney")
                    .version("v1.0.0")
            )
    }
}