package com.mepemproject.mepemproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mepemproject.mepemproject.model.Registrationmodel;
import com.mepemproject.mepemproject.repository.RegistrarionRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrarionRepository registrarionRepository;

    // Method to create a new registration
    public boolean createRegistration(Registrationmodel newRegistration) {
        try {
            registrarionRepository.save(newRegistration);
            return true;
        } catch (Exception e) {
            // Handle exceptions if necessary
            return false;
        }
    }

    // Method to update registration details
    public boolean updateRegistration(Long id, Registrationmodel updatedRegistration) {
        try {
            Registrationmodel existingRegistration = registrarionRepository.findById(id).orElse(null);
            if (existingRegistration != null) {
                // Update fields based on your requirements
                existingRegistration.setFullname(updatedRegistration.getFullname());
                existingRegistration.setPhoneNo(updatedRegistration.getPhoneNo());
                existingRegistration.setEmail(updatedRegistration.getEmail());
                existingRegistration.setPasswd(updatedRegistration.getPasswd());

                registrarionRepository.save(existingRegistration);
                return true;
            } else {
                return false; // Registration with given id not found
            }
        } catch (Exception e) {
            // Handle exceptions if necessary
            return false;
        }
    }

    // Method to delete a registration
    public boolean deleteRegistration(Long id) {
        try {
            registrarionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // Handle exceptions if necessary
            return false;
        }
    }

    // Method to get registration details by id
    public Registrationmodel getRegistrationById(Long id) {
        try {
            return registrarionRepository.findById(id).orElse(null);
        } catch (Exception e) {
            // Handle exceptions if necessary
            return null;
        }
    }

    // Method to find registration by email
    public Registrationmodel findRegistrationByEmail(String email) {
        try {
            return registrarionRepository.findByEmail(email);
        } catch (Exception e) {
            // Handle exceptions if necessary
            return null;
        }
    }

    // Method to find registration by phone number
    public Registrationmodel findRegistrationByPhoneNo(String phoneNo) {
        try {
            return RegistrarionRepository.findByPhoneNo(phoneNo);
        } catch (Exception e) {
            // Handle exceptions if necessary
            return null;
        }
    }
}
