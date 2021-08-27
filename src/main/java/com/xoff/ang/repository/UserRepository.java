package com.xoff.ang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xoff.ang.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}