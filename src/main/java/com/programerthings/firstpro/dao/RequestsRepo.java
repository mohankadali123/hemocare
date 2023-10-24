package com.programerthings.firstpro.dao;

import org.springframework.data.repository.CrudRepository;

import com.programerthings.firstpro.model.Requests;

public interface RequestsRepo extends CrudRepository<Requests, String> {
      Requests findByEmail(String email);
}
