# Customer Feedback API

## Table of Contents

- [Description](#description)
- [Why I Built It](#why-i-built-it)
- [Tech Stack & Features](#tech-stack--features)
- [How To Run Locally](#how-to-run-locally)
- [Future Development](#future-development)

## Description

This project features a small API service for users to post and read product reviews.

## Why I Built It

I found this project on the Java projects page offered by HyperSkill. I thought it would be a good project
to practice basic HTTP handling with POST and GET requests as well as give me a chance to try out paging and
filtering. I also utilized this project to practice making git commits and pushing updated code to the github 
repository for the project as I was building it. 

## Tech Stack & Features

Tech Stack:
- Java
- Spring Boot
- MongoDB
- Maven

Features:
- Submit reviews
- Read reviews
- Optionally filter reviews by customer, rating, vendor or product
- Paginated results 

## How To Run Locally

**1. Clone the repository**
git clone https://github.com/Diackj/customerFeedback-java.git

**2. Set up MongoDB**
- set up a MongoDB database (e.g. feedback_db)
- create a collection named "reviews"

**3. Navigate to the folder**
cd customerfeedback

**4. Configure environment variables**
- locate the main file where the spring application is run (CustomerfeedbackApplication.java) and remove 
or comment out the static EnvLoader script.
- navigate to the application.properties file and input your database name and URI connection string.

**5. Run the program**
./mvnw spring-boot:run 

## Future Development

- Add a User entity where users are prompted to enter a unique username so reviews can better be filtered by 
username rather than just customer to prevent shared names from altering a viewer's search.
- Add authentication so only authenticated users can post reviews while reading reviews can be open to everyone.