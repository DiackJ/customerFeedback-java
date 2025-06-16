package com.springboot.customerfeedback;

import com.springboot.customerfeedback.DTO.ReviewDTO;
import com.springboot.customerfeedback.Model.Review;
import com.springboot.customerfeedback.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
public class Controller {
    @Autowired
    public final FeedbackService feedbackService;

    public Controller(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @PostMapping("/submit-review")
    public ResponseEntity<String> submitReview(@RequestBody ReviewDTO dto){
        feedbackService.postReview(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review submitted!");
    }

    @GetMapping("/reviews")
    public Page<Review> getPageResults(@RequestParam(required = false) String customer
    , @RequestParam(required = false) String vendor, @RequestParam(required = false) String product, @RequestParam(required = false) Double rating, @PageableDefault(size = 10, sort = "date", direction = Sort.Direction.DESC) Pageable page){
        return feedbackService.pageAndFilterReviews(customer, vendor, product, rating, page);
    }
}
