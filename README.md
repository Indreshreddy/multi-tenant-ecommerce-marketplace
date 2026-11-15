# Multi-Tenant E-Commerce Marketplace & Vendor Management System

A backend-only REST API built using Java 17, Spring Boot, Spring Data JPA, Hibernate, and H2. No frontend is included.

## Features

- Create marketplace tenants.
- Create and list tenant-specific vendors.
- Create and list products.
- Products can only reference vendors belonging to the same tenant.
- Create and list tenant-specific customer orders.
- Tenant scoping through the `X-Tenant-Id` request header.
- Request validation and HTTP error responses.
- H2 file-based database for local development.

## Technologies Used

- Java 17
- Spring Boot 3.3.5
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- REST APIs
- Postman
- SQL

## Requirements

- Java 17 or later
- Maven 3.6 or later

## Run the Project

Open a terminal in the project directory and execute:

```bash
mvn spring-boot:run
```

API Base URL:

`http://localhost:8080`

## H2 Database

H2 Console:

`http://localhost:8080/h2-console`

Database connection details:

- JDBC URL: `jdbc:h2:file:./data/marketplace`
- Username: `sa`
- Password: Leave blank

## API Endpoints

All tenant-specific requests require the following HTTP header:

`X-Tenant-Id: 1`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/tenants` | Create tenant |
| POST | `/api/vendors` | Create vendor |
| GET | `/api/vendors` | List vendors |
| POST | `/api/products` | Create product |
| GET | `/api/products` | List products |
| POST | `/api/orders` | Create customer order |
| GET | `/api/orders` | List orders |

## Sample API Requests

### 1. Create Tenant

**POST** `/api/tenants`

```json
{
  "name": "Demo Marketplace",
  "slug": "demo-marketplace"
}
```

### 2. Create Vendor

**POST** `/api/vendors`

Header: `X-Tenant-Id: 1`

```json
{
  "name": "ABC Traders",
  "email": "vendor@example.com",
  "phone": "9876543210"
}
```

### 3. Create Product

**POST** `/api/products`

Header: `X-Tenant-Id: 1`

```json
{
  "vendorId": 1,
  "name": "Wireless Mouse",
  "description": "Ergonomic mouse",
  "price": 799.00,
  "stock": 25
}
```

### 4. Create Customer Order

**POST** `/api/orders`

Header: `X-Tenant-Id: 1`

```json
{
  "customerName": "Demo Customer",
  "customerEmail": "customer@example.com",
  "totalAmount": 799.00
}
```

## API Testing

All seven API requests were tested successfully using Postman:

- Create Tenant
- Create Vendor
- Create Product
- Create Customer Order
- List Vendors
- List Products
- List Orders

Database storage and retrieval were also verified using SQL queries in the H2 Console.

## Limitations

This is an educational portfolio project, not a production-ready commerce platform.

The current implementation does not include:

- User login and authentication.
- Payment processing.
- Order line items.
- Automatic inventory deduction.

Tenant IDs are supplied through a request header for demonstration. Production systems should derive tenant identity from an authenticated user rather than trusting a client-supplied header.