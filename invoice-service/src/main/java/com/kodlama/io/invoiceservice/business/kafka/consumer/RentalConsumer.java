package com.kodlama.io.invoiceservice.business.kafka.consumer;

import com.kodlama.io.invoiceservice.business.abstracts.InvoiceService;
import com.kodlama.io.invoiceservice.entities.Invoice;
import com.kodlamaio.commonpackage.events.invoice.InvoiceCreatedEvent;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


    @Service
    @RequiredArgsConstructor
    public class RentalConsumer {
        private final InvoiceService service;
        private final ModelMapperService mapper;
        @KafkaListener(
                topics = "invoice-created",
                groupId = "1"
        )
        public void consume(InvoiceCreatedEvent event) {
            var invoice = mapper.forRequest().map(event, Invoice.class);
            service.add(invoice);
        }
    }

