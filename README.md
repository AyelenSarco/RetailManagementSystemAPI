# RetailManagementSystem

A REST API built with Spring Boot, designed to manage products, sales, customers, and inventory.
It demonstrates solid backend practices and a clean, scalable architecture.

## Architecture

- The application follows a layered architecture:
  -  Controller → Service → Repository → Entity
  - Clear separation of concerns
  - DTO-based communication between layers

## Key Features

- Product management
- Sales management
- Customer management
- Stock control and validation
- Daily sales reports
- Proper error handling with custom exceptions

## Domain Model

- A Product has a name, brand, current price, and available stock.
- A Sale belongs to a Customer and contains multiple products.
- A Customer can have multiple sales.
- Sales and products are related through a SaleDetail entity:
  - Quantity of each product
  - Unit price at the time of sale
  - Subtotal calculation
- Stock is validated and updated when a sale is created.
- Business reports are generated using aggregated data (not domain entities).

## Implemented Features

- Full CRUD operations for:
  - Products
  - Customers
  - Sales
- Stock validation:
  - Prevents sales when stock is insufficient
  - Allows checking products below a minimum stock threshold
- Business reports:
  - Daily sales summary (total amount and total sales count)
  - Highest sale summary (sale with the maximum total amount)
- DTO-based request and response handling
- Centralized exception handling

## Persistence

- MySQL database
- ORM mapping using JPA / Hibernate
- Entity relationships:
  - One-to-Many (Customer → Sale)
  - One-to-Many (Sale → SaleDetail)
  - Many-to-One (SaleDetail → Product)
- Proper handling of many-to-many relationships via intermediate entities

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- MapStruct

## Configuration

Environment variables are loaded from a .env file
Example configuration files are included in the repository:
- `.env.example`
- `application.example.properties`

These files can be used as a reference to configure the application locally.

## Build and Run the Application

1. Configure environment variables using `.env`
2. Configure database properties in `application.properties`
3. Run the application from your IDE or using Maven:
    ```bash
      mvn spring-boot:run
    ```
   
## Future Improvements
- Logging and monitoring
- Improved validation rules 
- API documentation (Swagger / OpenAPI)
- Docker Support

## Postman Collection

A Postman collection with example requests is included in the repository.
You can import it directly from: `postman/RetailManagementSystem.postman_collection.json`