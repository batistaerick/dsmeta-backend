package com.erick.dsmeta.converters;

import com.erick.dsmeta.dtos.SaleDTO;
import com.erick.dsmeta.entities.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleConverter {

    public Sale dtoToEntity(SaleDTO dto) {
        Sale entity = new Sale();
        entity.setAmount(dto.getAmount());
        entity.setDeals(dto.getDeals());
        entity.setDate(dto.getDate());
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setVisited(dto.getVisited());
        return entity;
    }

    public SaleDTO entityToDTO(Sale entity) {
        SaleDTO dto = new SaleDTO();
        dto.setAmount(entity.getAmount());
        dto.setDeals(entity.getDeals());
        dto.setDate(entity.getDate());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setVisited(entity.getVisited());
        return dto;
    }

}
