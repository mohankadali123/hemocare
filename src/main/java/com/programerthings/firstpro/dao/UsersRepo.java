package com.programerthings.firstpro.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.programerthings.firstpro.model.Users;

public interface UsersRepo extends CrudRepository<Users, Integer>{
	
	List<Users> findByBloodGroup(String usersField);

}
