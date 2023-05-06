package com.kodlamaio.filterservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.StringTokenizer;
import java.util.UUID;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
    @Id
    private UUID id;
    private UUID carId;
    private UUID modelId;
    private UUID brandId;
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
    private double dailPrice;
    private String state;
}