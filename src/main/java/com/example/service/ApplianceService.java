package com.example.service;

import com.example.dto.ApplianceDto;
import com.example.exceptions.ApplianceNotFoundException;
import com.example.models.Appliance;
import com.example.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplianceService {

    private final ApplianceRepository applianceRepository;


    public List<Appliance> getAllAppliances() {
        return applianceRepository.findAll();
    }


    public Appliance createAppliance(ApplianceDto data) {
        return applianceRepository.save(ApplianceDto.toEntity(data));
    }

    public Appliance findApplianceById(Long id) {
        return applianceRepository.findById(id)
                .orElseThrow(() -> new ApplianceNotFoundException("Appliance with id '%s' not exists".formatted(id)));
    }

    public Appliance updateAppliance(Long id, ApplianceDto dto) {
        var appliance = findApplianceById(id);
        var updatedAppliance = Appliance.builder()
                .id(appliance.getId())
                .amount(dto.amount())
                .brand(dto.brand())
                .equipment(dto.equipment())
                .build();
        return applianceRepository.save(updatedAppliance);
    }

    public String deleteApplianceById(Long id) {
        var appliance = findApplianceById(id);
        applianceRepository.delete(appliance);
        return "Appliance by id '%s' successfully removed.";
    }

}
