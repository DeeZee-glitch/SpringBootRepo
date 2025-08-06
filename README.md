# Spring Boot Multi-Database CRUD API

This is a sample Spring Boot project demonstrating:

- Basic CRUD operations using **Spring Data JPA**
- Connection to **two different databases**
- RESTful API development using **Spring Web**
- Layered architecture (Controller → Service → Repository)
- **DTOs** for data transfer between layers
- **Input validation** and partial **exception handling**
- **Unit testing**

---

## 📌 Features

### CRUD with Spring Data JPA
- Basic Create, Read, Update, Delete operations
- Uses **two separate databases** (configured using `@Primary` and custom `DataSource` beans)

### RESTful API with Spring Web
- Endpoints exposed for entity operations (e.g. `/api/users`, `/api/products`)
- Uses `@RestController` and `@RequestMapping`

### Layered Architecture
