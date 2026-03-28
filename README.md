# CarritoCompras — Music Shop Full Stack

Full-stack application for a music products store. Spring Boot REST API connected to a React + Vite shopping cart frontend.

## Overview

This project combines a backend REST API (MusicShop) with a frontend guitar store (GuitarLA). It demonstrates a full-stack workflow: building a Spring Boot API, consuming it from a React client, and managing cart state with LocalStorage persistence.

## Tech Stack

**Backend**

![Java](https://img.shields.io/badge/Java_24-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.5-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)

- Java 24 + Spring Boot 3.5.5
- Spring Data JPA + Hibernate
- MySQL 8 database
- Lombok for boilerplate reduction
- RESTful API with custom exception handling

**Frontend**

![React](https://img.shields.io/badge/React_19-61DAFB?style=flat-square&logo=react&logoColor=black)
![Vite](https://img.shields.io/badge/Vite_7-646CFF?style=flat-square&logo=vite&logoColor=white)

- React 19 + Vite 7
- LocalStorage cart persistence
- Responsive CSS design

## Project Structure

```
CarritoCompras/
├── Back/                           # Spring Boot API
│   └── src/main/java/dogster/
│       ├── Application.java
│       ├── controller/             # REST endpoints
│       ├── model/                  # JPA entities
│       ├── repositories/           # JpaRepository interfaces
│       ├── service/                # Business logic
│       └── exception/              # Custom exception handling
└── Front/                          # React frontend (GuitarLA guitar shop)
    ├── src/
    ├── public/
    └── package.json
```

## Getting Started

### Backend

1. Create a MySQL database and configure `Back/src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/musicshop
   spring.datasource.username=your_user
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

2. Run from the `Back/` directory:
   ```bash
   ./mvnw spring-boot:run
   ```
   API runs on `http://localhost:8080`.

3. Refer to `Guide.txt` for detailed setup steps and database schema.

### Frontend

```bash
cd Front
npm install
npm run dev
```

Frontend runs on `http://localhost:5173` and connects to the backend API.

## Features

- Product catalog browsing
- Add/remove items from cart
- Quantity adjustment
- Cart total calculation
- Cart state persisted via LocalStorage between sessions

## Author

Marcos Padilla — [github.com/kabalera82](https://github.com/kabalera82)
