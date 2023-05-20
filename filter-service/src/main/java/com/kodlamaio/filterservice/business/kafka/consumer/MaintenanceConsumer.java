package com.kodlamaio.filterservice.business.kafka.consumer;

import com.kodlamaio.commonpackage.events.inventory.CarCreatedEvent;
import com.kodlamaio.commonpackage.events.maintenance.MaintenanceDeletedEvent;
import com.kodlamaio.commonpackage.events.rental.RentalDeletedEvent;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.filterservice.business.abstracts.FilterService;
import com.kodlamaio.filterservice.entities.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenanceConsumer {
    private final FilterService service;
    private final ModelMapperService mapper;
    @KafkaListener(
            topics = "maintenance-created",
            groupId = "filter-maintenance-create"
    )
    public void consume(CarCreatedEvent event) {
        var filter = mapper.forRequest().map(event, Filter.class);
        service.add(filter);
        log.info("Maintenance created event consumed {}", event);
    }
    @KafkaListener(
            topics = "maintenance-deleted",
            groupId = "filter-maintenance-delete"
    )
    public void consume(MaintenanceDeletedEvent  event) {
        var filter = service.getByCarId(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("Maintenance deleted event consumed {}", event);
    }

}
