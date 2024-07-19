package com.mepemproject.mepemproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mepemproject.mepemproject.model.Usermodel;


public interface Userrepository extends JpaRepository<Usermodel, Long> {

Usermodel findByUsernameAndPassword(String username, String password);
}
