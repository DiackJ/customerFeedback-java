package com.springboot.customerfeedback.DTO;

import com.springboot.customerfeedback.Model.Review;
import org.springframework.data.domain.Page;

import java.util.*;

public class PageDTO {
    private int totalDocs;
    private boolean isFirstPage;
    private boolean isLastPage;
    private int currentPage;
    private int totalPages;
    private List<Review> reviews;
    private Page<Review> pages;

    public PageDTO(){
        this.reviews = new ArrayList<>();
    }

    public int getTotalDocs(){return this.totalDocs;}
    public void setTotalDocs(int totalDocs){this.totalDocs = totalDocs;}

    public void setIsFirstPage(boolean isFirstPage){this.isFirstPage = isFirstPage;}

    public void setIsLastPage(boolean isLastPage){this.isLastPage = isLastPage;}

    public int getCurrentPage(){return this.currentPage;}
    public void setCurrentPage(int currentPage){this.currentPage = currentPage;}

    public int getTotalPages(){return this.totalPages;}
    public void setTotalPages(int totalPages){this.totalPages = totalPages;}

    public void setPages(Page<Review> pages){this.pages = pages;}
}
