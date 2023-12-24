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

## Authentication
The application includes an authentication structure to verify user identity and authorize access. I have only left "/api/ucuslar/ucusbul" to be public so that users can search through their desired flights. 
Anything else is secured by basic auth which wants admin for username and admin for password. Because anything besides looking for flight information includes of CRUD operations which needs to be protected.

## Scheduled Background Jobs
A scheduled background job runs every 5 minutes to fetch flight information from a mock third-party API and stores it in the database. Every 5 minutes 10 new flights are generated randomly and saved to the database. 
```
@Scheduled(fixedRate = 300000) // 300,000 milliseconds = 5 minutes
    public void fetchFlightInfo() {
         MockApiService mockApiService = new MockApiService();
         List<Ucuslar> flightInfoList = mockApiService.fetchMockData();
         ucuslarRepository.saveAll(flightInfoList);
         System.out.println("Scheduled job ran at: " + System.currentTimeMillis());
    }
```
For instance;
```
Kalkış Havaalanı ID: 11
Varış Havaalanı ID: 1
Kalkış Tarih Saati: 2023-12-28 12:07:25.334
Dönüş Tarih Saati: 2024-01-28 17:12:36.943
Fiyat: 353.55
-----------------------------
Kalkış Havaalanı ID: 1
Varış Havaalanı ID: 9
Kalkış Tarih Saati: 2024-01-10 18:40:35.5
Dönüş Tarih Saati: 2024-01-14 03:33:08.116
Fiyat: 380.34
-----------------------------
Kalkış Havaalanı ID: 11
Varış Havaalanı ID: 7
Kalkış Tarih Saati: 2024-01-14 18:45:09.294
Dönüş Tarih Saati: 2024-01-01 08:18:09.969
Fiyat: 172.7
-----------------------------
```

## Technology Stack
* Java (Spring Boot)
* Database (SQL/NoSQL)
* Authentication Mechanism
* Scheduled Jobs
* Swagger for API Documentation

  
## Getting Started
* Clone the repository
* Set up the database

## Run the application
Documentation
API documentation is available using Swagger. Access the documentation at Swagger UI.
Here is my tables to store flight and airport information.
```
CREATE TABLE ucuslar (
    id SERIAL PRIMARY KEY,
    kalkis_havaalani_id INTEGER REFERENCES havaalanlari(id),
    varis_havaalani_id INTEGER REFERENCES havaalanlari(id),
    kalkis_tarih_saati TIMESTAMP NOT NULL,
    donus_tarih_saati TIMESTAMP,
    fiyat NUMERIC(10, 2) NOT NULL
);



CREATE TABLE havaalanlari (
    id SERIAL PRIMARY KEY,
    sehir VARCHAR(255) NOT NULL
);
```

Query Parameters: 
* kalkisYeri=1: This query parameter indicates the departure location or origin of the flight. The value "1" might represent a specific location code or identifier.
* varisYeri=2: This query parameter indicates the arrival location or destination of the flight. The value "2" might represent a specific location code or identifier.
* kalkisTarihi=2023-01-01: This query parameter represents the departure date of the flight. The value "2023-01-01" is in the format YYYY-MM-DD.
* donusTarihi=2023-01-05: This query parameter represents the return date of the flight in case it's a round-trip. The value "2023-01-05" is in the format YYYY-MM-DD.
* In summary, this URL is a request to the server's "/api/ucuslar/ucusbul" endpoint, asking to find flights based on specific criteria such as departure location, arrival location, departure date, and return date.
* The server would handle this request, process the parameters, and return relevant flight information based on the search criteria. The actual logic and behavior of the endpoint would depend on the implementation of the server-side code handling this API endpoint.
```
http://localhost:8080/api/ucuslar/ucusbul?kalkisYeri=1&varisYeri=2&kalkisTarihi=2023-01-01&donusTarihi=2023-01-05
```
