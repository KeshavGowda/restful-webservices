package com.keshav.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keshav.webservice.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
