package com.barbershop.manager.controllers;

import com.barbershop.manager.models.Location;
import com.barbershop.manager.models.Sale;
import com.barbershop.manager.repositories.BuyerInfoRepository;
import com.barbershop.manager.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private BuyerInfoRepository buyerInfoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<Sale>> getAllSales(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Sale> sales = saleRepository.findAll(pageable);
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {

        Sale newSale = saleRepository.save(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
    }

}
