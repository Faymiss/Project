package com.mepemproject.mepemproject.service;

import com.mepemproject.mepemproject.model.Billmodel;
import com.mepemproject.mepemproject.repository.Billrepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Billservice {

    private final Billrepository billRepository;

   
    public Billservice(Billrepository billRepository) {
        this.billRepository = billRepository;
    }

    // Kuokoa Bill mpya
    public Billmodel saveBill(Billmodel bill) {
        return billRepository.save(bill);
    }

    // Kupata Bill kwa kutumia ID
    public Optional<Billmodel> getBillById(Long id) {
        return billRepository.findById(id);
    }

    // Kupata orodha ya Bili zote
    public List<Billmodel> getAllBills() {
        return billRepository.findAll();
    }

    // Kusasisha Bill iliyopo
    public Billmodel updateBill(Long id, Billmodel updatedBill) {
        Optional<Billmodel> billOptional = billRepository.findById(id);
        if (billOptional.isPresent()) {
            Billmodel bill = billOptional.get();
            // Update properties
            bill.setCompany(updatedBill.getCompany());
            bill.setMeterNo(updatedBill.getMeterNo());
            bill.setPrice(updatedBill.getPrice());
            bill.setPhone(updatedBill.getPhone());
            bill.setPasswd(updatedBill.getPasswd());
            return billRepository.save(bill); // <-- Use billRepository to save the updated bill
        } else {
            throw new RuntimeException("Bill not found with id: " + id);
        }
    }

    // Kufuta Bill kwa kutumia ID
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
}
