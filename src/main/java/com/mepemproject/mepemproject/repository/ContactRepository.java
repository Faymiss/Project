package com.mepemproject.mepemproject.repository;

import com.mepemproject.mepemproject.model.contactmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<contactmodel, Long> {
    // Hapa unaweza kuongeza mbinu za ziada za kufanya kazi na mawasiliano
    // Kama unataka utafute mawasiliano kwa barua pepe:
    // public Optional<contactmodel> findByEmail(String email);
}
