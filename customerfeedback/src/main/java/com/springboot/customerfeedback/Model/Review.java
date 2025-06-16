package com.springboot.customerfeedback.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {
    @Id
    private ObjectId id;
    private String customer;
    private String vendor;
    private String product;
    private double rating;
    private String feedback;

    public Review(){}

    public void setCustomer(String customer){this.customer = customer;}
    public void setVendor(String vendor){this.vendor = vendor;}
    public void setProduct(String product){this.product = product;}
    public void setRating(double rating){this.rating = rating;}
    public void setFeedback(String feedback){this.feedback = feedback;}
}
