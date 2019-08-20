package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Merchant;
import com.cg.bean.Product;

@Repository 
public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	@Query("select p from Product p where p.merchant=?1")
	public List<Product> getAllProductsForMerchant(Merchant merchantObject);

}
