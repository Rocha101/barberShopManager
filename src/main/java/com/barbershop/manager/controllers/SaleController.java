package com.barbershop.manager.controllers;

import com.barbershop.manager.models.BuyerInfo;
import com.barbershop.manager.models.Sale;
import com.barbershop.manager.repositories.BuyerInfoRepository;
import com.barbershop.manager.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        Sale newSale = saleRepository.save(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
    }

}
