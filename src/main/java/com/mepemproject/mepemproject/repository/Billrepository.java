package com.mepemproject.mepemproject.repository;

import com.mepemproject.mepemproject.model.Billmodel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Billrepository extends JpaRepository<Billmodel, Long> {

    // Unaweza kuongeza mahitaji ya desturi ya kuuliza hapa ikihitajika
}
