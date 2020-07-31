package com.josalero.articles.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josalero.articles.hibernate.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{

}
