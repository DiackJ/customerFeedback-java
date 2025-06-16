package com.springboot.customerfeedback.DTO;

public class ReviewDTO {
    private String customer;
    private String vendor;
    private String product;
    private double rating;
    private String feedback;

    public ReviewDTO(){}

    public String getCustomer(){return this.customer;}
    public String getVendor(){return this.vendor;}
    public String getProduct(){return this.product;}
    public double getRating(){return this.rating;}
    public String getFeedback(){return this.feedback;}

}
