package com.kodlama.io.invoiceservice.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoicesResponse {
    String id;
    UUID carId;
    String cardHolder;
    String brandName;
    String plate;
    int modelYear;
    double dailyPrice;
    LocalDate rentedAt;
    int rentedForDays;
    double totalPrice;
}