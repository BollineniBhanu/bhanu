package com.cg.bean;

public class ReviewModel {
	
	
	//For input from angular
	Integer reviewId;

	Integer userId;
	Integer productId;
	String reviewFeedback;
	Integer stars;
	
	public ReviewModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ReviewModel(Integer userId, Integer productId, String reviewFeedback, Integer stars) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.reviewFeedback = reviewFeedback;
		this.stars = stars;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getReviewFeedback() {
		return reviewFeedback;
	}

	public void setReviewFeedback(String reviewFeedback) {
		this.reviewFeedback = reviewFeedback;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "ReviewModel [userId=" + userId + ", productId=" + productId + ", reviewFeedback=" + reviewFeedback
				+ ", stars=" + stars + "]";
	}
	

}
