package com.mepemproject.mepemproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mepemproject.mepemproject.model.Registrationmodel;
import com.mepemproject.mepemproject.service.RegistrationService;

@RestController
@RequestMapping("/api")
public class Registrationcontroller {

    @Autowired
    private RegistrationService RegistrationService;

    // POST Method: Create a new registration
    @PostMapping("/registrations")
    public ResponseEntity<String> createRegistration(@RequestBody Registrationmodel newRegistration) {
        boolean created = RegistrationService.createRegistration(newRegistration);
        if (created) {
            return ResponseEntity.ok("Registration created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create registration");
        }
    }

    // PUT Method: Update registration details
    @PutMapping("/registrations/{id}")
    public ResponseEntity<String> updateRegistration(@PathVariable Long id, @RequestBody Registrationmodel updatedRegistration) {
        boolean updated = RegistrationService.updateRegistration(id, updatedRegistration);
        if (updated) {
            return ResponseEntity.ok("Registration updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE Method: Delete registration by ID
    @DeleteMapping("/registrations/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
        boolean deleted = RegistrationService.deleteRegistration(id);
        if (deleted) {
            return ResponseEntity.ok("Registration deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET Method: Get registration details by ID
    @GetMapping("/registrations/{id}")
    public ResponseEntity<Registrationmodel> getRegistrationById(@PathVariable Long id) {
        Registrationmodel registration = RegistrationService.getRegistrationById(id);
        if (registration != null) {
            return ResponseEntity.ok(registration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET Method: Find registration by email
    @GetMapping("/registrations/email/{email}")
    public ResponseEntity<Registrationmodel> findRegistrationByEmail(@PathVariable String email) {
        Registrationmodel registration = RegistrationService.findRegistrationByEmail(email);
        if (registration != null) {
            return ResponseEntity.ok(registration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET Method: Find registration by phone number
    @GetMapping("/registrations/phone/{phoneNo}")
    public ResponseEntity<Registrationmodel> findRegistrationByPhoneNo(@PathVariable String phoneNo) {
        Registrationmodel registration = RegistrationService.findRegistrationByPhoneNo(phoneNo);
        if (registration != null) {
            return ResponseEntity.ok(registration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
