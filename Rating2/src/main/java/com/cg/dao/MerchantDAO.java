package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Merchant;

@Repository
public interface MerchantDAO  extends JpaRepository<Merchant, Integer>{
	@Transactional
	@Modifying
	@Query("update Merchant m set m.rating=?2 where m.merchantId=?1")
	public void updateMerchantRating(Integer merchantId,Double rating);

}
