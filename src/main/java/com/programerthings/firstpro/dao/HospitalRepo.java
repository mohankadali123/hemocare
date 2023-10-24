package com.programerthings.firstpro.dao;

import org.springframework.data.repository.CrudRepository;

import com.programerthings.firstpro.model.Hospitals;

public interface HospitalRepo extends CrudRepository<Hospitals, Integer>{
      Hospitals findByHid(int hid);
}
