package com.example.controller;

import com.example.dto.ApplianceDto;
import com.example.models.Appliance;
import com.example.service.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplianceController {

    private final ApplianceService applianceService;

    @QueryMapping()
    public List<Appliance> getAppliances() {
        return applianceService.getAllAppliances();
    }

    @MutationMapping
    public Appliance createNewAppliance(@Argument ApplianceDto dto) {
        return applianceService.createAppliance(dto);
    }

    @MutationMapping
    public Appliance updateAppliance(@Argument Long id, @Argument ApplianceDto dto) {
        return applianceService.updateAppliance(id, dto);
    }

    @MutationMapping
    public String deleteAppliance(@Argument Long id) {
        return applianceService.deleteApplianceById(id);
    }

}
