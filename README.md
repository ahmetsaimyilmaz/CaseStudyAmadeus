# Flight Search API
Flight Search API is a backend application developed for a flight search application. It provides CRUD operations for flights and airports, as well as a search API to retrieve relevant flight information based on departure and arrival locations, departure date, and return date.

## Table of Contents
* Data Modeling
* CRUD Operations
* Search API
* RESTful Service
* Authentication
* Scheduled Background Jobs
* Technology Stack
* Getting Started
* Documentation
* Contact

  
## Data Modeling
  
The application uses a relational (PostgreSQL) database to store the following information:

## Flights
* ID
* Departure airport
* Arrival airport
* Departure date/time
* Return date/time
* Price
  
## Airports
* ID
* City

  
## CRUD Operations

The application follows the CRUD structure for managing data, allowing users to Create, Read, Update, and Delete flight and airport information.


## Search API
The Search API endpoint retrieves flights based on the provided departure and arrival locations, departure date, and return date. It returns single-flight information for one-way trips and two-flight information for round trips.

## RESTful Service
The API adheres to REST principles, making it easy to interact with other systems. It is implemented in Java using the Spring Boot framework.

Authentication
The application includes an authentication structure to verify user identity and authorize access.

## Scheduled Background Jobs
A scheduled background job runs every 5 minutes to fetch flight information from a mock third-party API and stores it in the database.

## Technology Stack
* Java (Spring Boot)
* Database (SQL/NoSQL)
* Authentication Mechanism
* Scheduled Jobs
* Swagger for API Documentation
## Getting Started
* Clone the repository
* Set up the database

* Run the application
Documentation
API documentation is available using Swagger. Access the documentation at Swagger UI.
