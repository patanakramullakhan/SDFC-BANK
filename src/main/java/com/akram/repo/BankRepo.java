package com.akram.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akram.entity.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {

}
