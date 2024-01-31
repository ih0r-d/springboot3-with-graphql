package com.example.service;

import com.example.dto.ApplianceDto;
import com.example.models.Appliance;
import com.example.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplianceService {

    private final ApplianceRepository applianceRepository;


    public List<Appliance> getAllAppliances(){
        return applianceRepository.findAll();
    }


    public Appliance createAppliance(ApplianceDto data){
        return applianceRepository.save(ApplianceDto.toEntity(data));
    }

}
