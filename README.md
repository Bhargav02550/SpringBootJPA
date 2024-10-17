# Spring Boot JPA

## What is JPA?
**JPA (Java Persistence API)** is a specification in Java that is used for managing and interacting with relational data in Java applications. It simplifies the process of mapping Java objects (entities) to relational database tables, allowing developers to work with databases using object-oriented principles. 

JPA follows the **Object-Relational Mapping (ORM)** paradigm, which provides a way to map the object model of a Java program to the relational model of a database. 

### Key Features of JPA:
- **Object-Relational Mapping (ORM):** JPA maps Java classes (entities) to database tables and properties to columns. This eliminates the need to write complex SQL statements for basic database operations like CRUD (Create, Read, Update, Delete).
  
- **EntityManager API:** JPA provides the `EntityManager` interface, which is used to manage and persist entity instances. It allows developers to create, read, update, and delete records in the database.

- **Transactions:** JPA allows you to define and manage database transactions programmatically. Through the `EntityManager`, you can commit or roll back transactions based on application requirements.

- **JPQL (Java Persistence Query Language):** JPA uses JPQL, an object-oriented query language, for interacting with entities stored in the database. JPQL resembles SQL but operates on entity objects instead of directly on database tables.

## Benefits of Using JPA with Spring Boot:
- **Simplified Database Access:** Spring Boot with JPA reduces the amount of boilerplate code required to interact with databases.
- **Automatic Table Creation:** When using JPA, Spring Boot can automatically create database tables based on the entity definitions.
- **Built-in Repository Support:** JPA repositories provided by Spring Data JPA allow for easy CRUD operations without needing to write explicit SQL queries.

## How JPA Works in Spring Boot:
1. **Entity Definition:** You define an entity class by annotating it with `@Entity`. This class represents a table in your database.
2. **Repository Layer:** Spring Data JPA provides repositories that handle basic CRUD operations for the entity without the need to write SQL queries.
3. **Service Layer:** The service layer is where the business logic resides. It interacts with the repository to perform the required operations.
4. **Transaction Management:** Spring provides automatic transaction management, or you can handle transactions programmatically using `@Transactional`.

## Example:
### Step 1: Define the Entity Class
```java
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    
    // Getters and Setters
}
