package com.springboot.customerfeedback.Service;

import com.springboot.customerfeedback.DTO.ReviewDTO;
import com.springboot.customerfeedback.Model.Review;
import com.springboot.customerfeedback.Repository.ReviewRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private final ReviewRepository reviewRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public FeedbackService(ReviewRepository reviewRepository, MongoTemplate mongoTemplate){
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }

    //user can post a product review
    public void postReview(ReviewDTO dto){
        Review review = new Review();

        review.setId(new ObjectId());

        if(dto.getCustomer().isEmpty() || dto.getCustomer() == null){
            review.setCustomer("Anonymous"); //set customer name to "anonymous" if not provided
        }else{
            review.setCustomer(dto.getCustomer());
        }

        review.setVendor(dto.getVendor());
        review.setProduct(dto.getProduct());
        review.setRating(dto.getRating());

        if(dto.getFeedback().isEmpty() || dto.getFeedback() == null){
            review.setFeedback("");
        }else{
            review.setFeedback(dto.getFeedback());
        }

        review.setDate(new Date());

        reviewRepository.save(review);
    }

    //return a page of reviews with optional filtering
    public Page<Review> pageAndFilterReviews(String customer, String vendor, String product, Double rating, Pageable page){
        Query filter = new Query();

        //adding filters dynamically. filters will only be applied if not null, otherwise the query object will be ignored
        if(rating != null){
            //upper bound to only rating up to .9 (ex: 3.9)
            double upperBound = rating + 0.9;
            filter.addCriteria(Criteria.where("rating").lte(upperBound));
        }

        if(customer != null){
            filter.addCriteria(Criteria.where("customer").regex(customer, "i")); //"i" removes case restrictions so both upper and lowercase are valid
        }

        if(vendor != null){
            filter.addCriteria(Criteria.where("vendor").regex(vendor, "i"));
        }

        if(product != null){
            filter.addCriteria(Criteria.where("product").regex(product, "i"));
        }

        //so filtering still complies with paging
        filter.with(page);

        List<Review> filteredResults = mongoTemplate.find(filter, Review.class);
        //calculate count of documents to apply to paging. Like if page 1 shows 1-5, page 2 should show 5-10
        long docCount = mongoTemplate.count(filter.skip(-1).limit(-1), Review.class);

        //test mongo connection
//        List<Document> rawDocs = mongoTemplate.find(filter, Document.class, "reviews");
//        rawDocs.forEach(System.out::println);

        return new PageImpl<>(filteredResults, page, docCount);
    }
}
