package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Merchant;
import com.cg.bean.Product;
import com.cg.bean.Review;
import com.cg.bean.User1;
import com.cg.dao.MerchantDAO;
import com.cg.dao.ProductDAO;
import com.cg.dao.ReviewDAO;
import com.cg.dao.UserDAO;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	UserDAO userDao;
	@Autowired
	ProductDAO productDao;
	@Autowired
	ReviewDAO reviewDao;
	@Autowired
	MerchantDAO merchantDao;
	@Transactional(propagation = Propagation.REQUIRED)
	public String saveReview(Integer userId, Integer productId, Integer stars, String reviewFeedback) {

		User1 userObject = userDao.findById(userId).get();
		Product productObject = productDao.findById(productId).get();

		Review reviewObject = new Review(productObject, reviewFeedback, userObject, stars);

		try {
			reviewDao.saveAndFlush(reviewObject);

		} catch (Exception e) {
			return e.getMessage();
		}
		return "Review Added";

	}

	@Transactional(readOnly = true)
	public Double getAverageReview(Integer productId) {

		Product productObject = productDao.getOne(productId);
		if (productObject == null)
			return null;
		else {
			List<Integer> starsList = reviewDao.getStarsForProduct(productObject);
			Double averageStar = 0.0;
			for (Integer i : starsList) {
				averageStar = (averageStar + i);

			}
			int size = starsList.size();
			averageStar = averageStar / size;
			return averageStar;
		}
	}

	public Double getAverageMerchantReview(Integer merchantId) {
		Merchant merchantObject= merchantDao.findById(merchantId).get();
		System.out.println(merchantObject);
		List<Product> productsList=productDao.getAllProductsForMerchant(merchantObject);
		System.out.println(productsList);
		List<Double> productsStarsList=new ArrayList<Double>();
		Double i=0.0;
		for(Product p : productsList) {
			System.out.println(p.getProductID());
			List<Review> reviewList=reviewDao.getReviewForProduct(p);
			if(reviewList.isEmpty())
			{
				//do nothing
			}
			else {
			i=getAverageReview(p.getProductID());
			productsStarsList.add(i);
			}
		}
		
		Double averageMerchantRating=0.0;
		
		for(Double d:productsStarsList) {
			averageMerchantRating+=d;
		}
		
		averageMerchantRating=averageMerchantRating/productsStarsList.size();
		
		merchantDao.updateMerchantRating(merchantId, averageMerchantRating);
		
		return averageMerchantRating;
		
		
		
		
		
		
		
		
	}

}
