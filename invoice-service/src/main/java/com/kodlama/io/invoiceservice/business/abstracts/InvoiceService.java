package com.kodlama.io.invoiceservice.business.abstracts;

import com.kodlama.io.invoiceservice.business.dto.GetAllInvoicesResponse;
import com.kodlama.io.invoiceservice.business.dto.GetInvoiceResponse;
import com.kodlama.io.invoiceservice.entities.Invoice;


import java.util.List;
import java.util.UUID;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();

    GetInvoiceResponse getById(UUID id);
    void add(Invoice invoice);
    void delete(UUID id);
}
