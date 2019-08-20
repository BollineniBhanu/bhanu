package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bean.User1;

@Repository
public interface UserDAO  extends JpaRepository<User1, Integer>{

}
