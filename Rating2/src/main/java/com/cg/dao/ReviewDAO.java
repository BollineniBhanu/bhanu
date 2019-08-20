package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Product;
import com.cg.bean.Review;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Integer>{
	
	
	@Query("select r.star from Review r where r.product=?1")
	public List<Integer> getStarsForProduct(Product productObject);
	
	@Query("select r from Review r where r.product=?1")
	public List<Review> getReviewForProduct(Product productObject);

}
