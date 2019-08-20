package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.ReviewModel;
import com.cg.service.ReviewService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/review")
public class RatingController {
	@Autowired ReviewService reviewService; 
	
	
	@PostMapping(value="/addReviewForProduct",consumes="application/json")
	public String saveReview(@RequestBody ReviewModel reviewModelObject) {
		
		return reviewService.saveReview(reviewModelObject.getUserId(), reviewModelObject.getProductId(),
				reviewModelObject.getStars(), reviewModelObject.getReviewFeedback());
		
		
	}
	
	
	
	@GetMapping("/getAverageReviewProduct/{productId}")
	public Double getAverageReviewProduct(@PathVariable Integer productId) {
		return reviewService.getAverageReview(productId);
	}
	
	

	@GetMapping("/getAverageMerchantRating/{merchantId}")
	public Double getAverageMerchantReview(@PathVariable Integer merchantId) {
		System.out.println("In controller "+merchantId);
		return reviewService.getAverageMerchantReview(merchantId);
	}

}
