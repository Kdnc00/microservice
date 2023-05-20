package com.kodlamaio.maintenanceservice.business.concretes;

import com.kodlamaio.commonpackage.utils.constants.Paths;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import com.kodlamaio.maintenanceservice.business.abstracts.MaintenanceService;
import com.kodlamaio.maintenanceservice.business.dto.reponses.CreateMaintenanceResponse;
import com.kodlamaio.maintenanceservice.business.dto.reponses.GetAllMaintenancesResponse;
import com.kodlamaio.maintenanceservice.business.dto.reponses.GetMaintenanceResponse;
import com.kodlamaio.maintenanceservice.business.dto.reponses.UpdateMaintenanceResponse;
import com.kodlamaio.maintenanceservice.business.dto.requests.CreateMaintenanceRequest;
import com.kodlamaio.maintenanceservice.business.dto.requests.UpdateMaintenanceRequest;
import com.kodlamaio.maintenanceservice.business.rules.MaintenanceBusinessRules;
import com.kodlamaio.maintenanceservice.entities.Maintenance;
import com.kodlamaio.maintenanceservice.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapperService mapper;
    private final MaintenanceBusinessRules rules;


    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance>maintenances = repository.findAll();
        List<GetAllMaintenancesResponse> maintenancesResponses = maintenances
                .stream().map(maintenance -> mapper.forResponse().map(maintenance, GetAllMaintenancesResponse.class)).toList();
        return maintenancesResponses;
    }

    @Override
    public GetMaintenanceResponse getById(UUID id) {
        var maintenance = repository.findById(id).orElseThrow();
        var maintenancesResponses = mapper.forResponse().map(maintenance,GetMaintenanceResponse.class);
        return maintenancesResponses;
    }

    @Override
    public GetMaintenanceResponse returnCarFromMaintenance(UUID carId) {
        return null;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        var maintenance = mapper
        return null;
    }

    @Override
    public UpdateMaintenanceResponse update(UUID id, UpdateMaintenanceRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
