package com.erick.dsmeta.repositories;

import com.erick.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :start AND :end ORDER BY obj.amount DESC")
    Page<Sale> findBetweenDates(LocalDate start, LocalDate end, Pageable pageable);

}
