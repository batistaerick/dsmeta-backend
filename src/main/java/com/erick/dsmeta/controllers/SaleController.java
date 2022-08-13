package com.erick.dsmeta.controllers;

import com.erick.dsmeta.dtos.SaleDTO;
import com.erick.dsmeta.entities.Sale;
import com.erick.dsmeta.services.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@Log4j2
public class SaleController {

    private final SaleService service;

    @PostMapping()
    public ResponseEntity<Sale> save(SaleDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping()
    public ResponseEntity<List<Sale>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/find-between-dates")
    public ResponseEntity<Page<Sale>> findBetweenDates(@DateTimeFormat(pattern = "dd/MM/yyyy")
                                                      @RequestParam LocalDate start,
                                                      @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                      @RequestParam LocalDate end,
                                                      Pageable pageable) {
        return ResponseEntity.ok(service.findBetweenDates(start, end, pageable));
    }

}
