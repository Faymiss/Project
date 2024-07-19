package com.mepemproject.mepemproject.controller;

import com.mepemproject.mepemproject.model.Billmodel;
import com.mepemproject.mepemproject.service.Billservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
public class Billcontroller {

    private final Billservice billService;

  
    public Billcontroller(Billservice billService) {
        this.billService = billService;
    }

    // Endpoint kuokoa Bill mpya
    @PostMapping("/create")
    public ResponseEntity<Billmodel> saveBill(@RequestBody Billmodel bill) {
        Billmodel savedBill = billService.saveBill(bill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    // Endpoint kupata Bill kwa kutumia ID
    @GetMapping("/{id}")
    public ResponseEntity<Billmodel> getBillById(@PathVariable Long id) {
        Optional<Billmodel> billOptional = billService.getBillById(id);
        return billOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint kupata orodha ya Bili zote
    @GetMapping("/all")
    public List<Billmodel> getAllBills() {
        return billService.getAllBills();
    }

    // Endpoint kusasisha Bill iliyopo
    @PutMapping("/update/{id}")
    public ResponseEntity<Billmodel> updateBill(@PathVariable Long id, @RequestBody Billmodel updatedBill) {
        Billmodel bill = billService.updateBill(id, updatedBill);
        return ResponseEntity.ok(bill);
    }

    // Endpoint kufuta Bill kwa kutumia ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
