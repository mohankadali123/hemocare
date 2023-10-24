package com.programerthings.firstpro.dao;

import org.springframework.data.repository.CrudRepository;

import com.programerthings.firstpro.model.BloodBank;

public interface BloodBankRepo extends CrudRepository<BloodBank, Integer>
{
    BloodBank findByHid(int hid); 
}
