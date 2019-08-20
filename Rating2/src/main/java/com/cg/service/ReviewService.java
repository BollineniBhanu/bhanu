package com.cg.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface ReviewService {
	
	public String saveReview(Integer userId,Integer productId,Integer stars,String reviewFeedback);
	
	public Double getAverageReview(Integer productId);
	
	public Double getAverageMerchantReview(Integer merchantId);

}
