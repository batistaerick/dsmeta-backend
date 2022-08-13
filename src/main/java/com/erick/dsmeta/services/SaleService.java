package com.erick.dsmeta.services;

import com.erick.dsmeta.converters.SaleConverter;
import com.erick.dsmeta.dtos.SaleDTO;
import com.erick.dsmeta.entities.Sale;
import com.erick.dsmeta.exceptions.SaleException;
import com.erick.dsmeta.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository repository;
    private final SaleConverter converter;

    public Sale save(SaleDTO dto) {
        return repository.save(converter.dtoToEntity(dto));
    }

    public List<Sale> findAll() {
        return repository.findAll();
    }

    public Sale findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new SaleException("User not found!"));
    }

    public Page<Sale> findBetweenDates(LocalDate start, LocalDate end, Pageable pageable) {
        return repository.findBetweenDates(start, end, pageable);
    }

}
