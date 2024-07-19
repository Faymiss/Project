package com.mepemproject.mepemproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mepemproject.mepemproject.model.Registrationmodel;

@Repository
public interface RegistrarionRepository extends JpaRepository<Registrationmodel, Long> {

    // Custom query method to find registration by email
    Registrationmodel findByEmail(String email);

    // Custom query method to find registration by phone number
    static Registrationmodel findByPhoneNo(String phone_no) {
     
        throw new UnsupportedOperationException("Unimplemented method 'findByPhoneNo'");
    }

    // You can add more custom query methods as needed

}
