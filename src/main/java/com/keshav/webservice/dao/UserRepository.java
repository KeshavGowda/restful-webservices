package com.keshav.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keshav.webservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
