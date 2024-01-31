package com.example.controller;

import com.example.models.Appliance;
import com.example.service.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplianceController {

    private final ApplianceService applianceService;

    @QueryMapping()
    List<Appliance> getAppliances(){
        return applianceService.getAllAppliances();
    }

}