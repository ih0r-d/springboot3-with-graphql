package com.example.dto;

import com.example.models.Appliance;

public record ApplianceDto(int amount, String brand, String equipment) {

    public static Appliance toEntity(ApplianceDto dto){
        return Appliance.builder()
                .amount(dto.amount())
                .brand(dto.brand())
                .equipment(dto.equipment())
                .build();
    }
}
