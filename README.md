
# Reservation Management API

A backend-focused RESTful API built with **Java 17** and **Spring Boot**, designed to demonstrate clean layering, consistent error handling, and enterprise-style backend development practices.

## 🚀 Key Features

* **RESTful API Design**: Resource-based routing and proper HTTP semantics.
* **Layered Architecture**: Clear separation between Controller, Service, and Repository layers.
* **DTO Pattern**: Data Transfer Objects used to decouple API contracts from persistence models.
* **Unified Response Format**: Consistent `ApiResponse` wrapper for predictable client integration.
* **Global Exception Handling**: Centralized error handling using `@RestControllerAdvice`.
* **Automated Validation**: Bean Validation (e.g. `@NotBlank`) at the API boundary.
* **Security Setup (Baseline)**: Basic Spring Security configuration prepared for future authentication enhancements.

## 🛠️ Tech Stack

* **Language**: Java 17
* **Framework**: Spring Boot 4.0.2
* **Data Access**: Spring Data JPA
* **Database**: H2 (In-memory for development/testing)
* **Security**: Spring Security
* **Validation**: Hibernate Validator
* **Build Tool**: Maven

## 📖 API Documentation

### Reservation Endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| `POST` | `/api/reservations` | Create a new reservation |
| `GET` | `/api/reservations` | List all reservations |
| `GET` | `/api/reservations/{id}` | Get details of a specific reservation |
| `GET` | `/api/reservations/health` | Service health check |

#### Sample Request Body (POST):

```json
{
  "customerName": "John Doe"
}

```

## 🏗️ Getting Started

### Prerequisites

* JDK 17 or higher
* Maven 3.6+ (or use the included wrapper `./mvnw`)

### Run the Application

1. Clone the repository.
2. Navigate to the project root.
3. Run the following command:
```bash
./mvnw spring-boot:run

```


4. The API will be available at `http://localhost:8080`.

---
