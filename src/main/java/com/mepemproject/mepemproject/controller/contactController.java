package com.mepemproject.mepemproject.controller;

import com.mepemproject.mepemproject.model.contactmodel;
import com.mepemproject.mepemproject.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts") // Base path for all endpoints in this controller
public class contactController {

    private final ContactRepository contactRepository;

   
    public contactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Endpoint to create a new contact
    @PostMapping("/")
    public ResponseEntity<contactmodel> createContact(@RequestBody contactmodel contact) {
        try {
            contactmodel newContact = contactRepository.save(contact);
            return new ResponseEntity<>(newContact, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to retrieve all contacts
    @GetMapping("/")
    public ResponseEntity<List<contactmodel>> getAllContacts() {
        try {
            List<contactmodel> contacts = contactRepository.findAll();
            if (contacts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to retrieve a single contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<contactmodel> getContactById(@PathVariable("id") Long id) {
        Optional<contactmodel> contactData = contactRepository.findById(id);

        return contactData.map(contact -> new ResponseEntity<>(contact, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to update a contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<contactmodel> updateContact(@PathVariable("id") Long id, @RequestBody contactmodel contact) {
        Optional<contactmodel> contactData = contactRepository.findById(id);

        if (contactData.isPresent()) {
            contactmodel existingContact = contactData.get();
            existingContact.setName(contact.getName());
            existingContact.setEmail(contact.getEmail());
            existingContact.setPhone(contact.getPhone());
            return new ResponseEntity<>(contactRepository.save(existingContact), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a contact by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") Long id) {
        try {
            contactRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
