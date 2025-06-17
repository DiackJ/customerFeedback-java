package com.springboot.customerfeedback.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reviews")
public class Review {
    @Id
    private ObjectId id;
    private String customer;
    private String vendor;
    private String product;
    private double rating;
    private String feedback;
    private Date dateSubmitted;

    public Review(){}

    public void setId(ObjectId id){this.id = id;}
    public ObjectId getId(){return this.id;}

    public void setCustomer(String customer){this.customer = customer;}
    public String getCustomer(){return this.customer;}

    public void setVendor(String vendor){this.vendor = vendor;}
    public String getVendor(){return this.vendor;}

    public void setProduct(String product){this.product = product;}
    public String getProduct(){return this.product;}

    public void setRating(double rating){this.rating = rating;}
    public double getRating(){return this.rating;}

    public void setFeedback(String feedback){this.feedback = feedback;}
    public String getFeedback(){return this.feedback;}

    public void setDate(Date date){this.dateSubmitted = date;}
    public Date getDate(){return this.dateSubmitted;}


    /* note to self:
    * in order to prevent null body returns for the document objects..
    * 1. make sure fields match exactly with the db schema
    * 2. even if you don't use them, you need getters otherwise spring has no way to map the usable
    * data for return or serialization. (also you can avoid all this boilerplate code by using lombok)*/
}
