package com.programerthings.firstpro.dao;

import org.springframework.data.repository.CrudRepository;

import com.programerthings.firstpro.model.Admin;

;

public interface AdminRepo extends CrudRepository<Admin, Integer>{
     Admin findByUsername(String username);
}
