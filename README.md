<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0ea5e9,100:6366f1&height=200&section=header&text=PrepWise%20Backend&fontSize=52&fontColor=ffffff&fontAlignY=38&desc=AI-Powered%20Placement%20Preparation%20Platform&descSize=18&descAlignY=58&descColor=e0f2fe" alt="PrepWise Banner" width="100%"/>

<br/>

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-336791?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203.0-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://swagger.io/)
[![JWT](https://img.shields.io/badge/JWT-Auth-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://jwt.io/)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

<br/>

> **PrepWise** is a production-grade, secure RESTful backend for an AI-powered placement preparation platform — built to help students crack coding interviews, aptitude tests, and company recruitment processes at scale.

<br/>

[🚀 Getting Started](#-getting-started) · [📖 API Docs](#-api-documentation) · [🐳 Docker Setup](#-docker-deployment) · [🤝 Contributing](#-contributing)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [System Architecture](#-system-architecture)
- [Project Structure](#-project-structure)
- [API Endpoints](#-api-endpoints)
- [Getting Started](#-getting-started)
- [Environment Variables](#-environment-variables)
- [Database Configuration](#-database-configuration)
- [Running Locally](#-running-locally)
- [Docker Deployment](#-docker-deployment)
- [API Documentation](#-api-documentation)
- [Security](#-security)
- [API Response Examples](#-api-response-examples)
- [Future Enhancements](#-future-enhancements)
- [Contributing](#-contributing)
- [License](#-license)

---

## 🎯 Overview

**PrepWise Backend** is the server-side engine powering a comprehensive placement preparation ecosystem. It provides secure, scalable APIs for:

- 🔐 **Authentication & Authorization** — Stateless JWT-based auth with role-based access control
- 📚 **Question Banks** — Coding and aptitude question management with tagging and filtering
- 🎯 **Interview Modules** — Structured preparation paths by company and role
- 📈 **Progress Tracking** — Per-user analytics on solved problems and mock test scores
- 🏆 **Leaderboards** — Competitive ranking across peers
- 🛡️ **Admin Dashboard APIs** — Full CRUD control for content and user management

> Built with a clean **Controller → Service → Repository** layered architecture, enforcing separation of concerns throughout the codebase.

---

## ✨ Features

| Feature | Status |
|---|---|
| JWT Authentication (Access + Refresh Tokens) | ✅ Live |
| Role-Based Access Control (USER / ADMIN) | ✅ Live |
| Student Profile Management | ✅ Live |
| Coding Question APIs (CRUD + Filter) | ✅ Live |
| Aptitude Question APIs | ✅ Live |
| Interview Preparation Modules | ✅ Live |
| Progress Tracking & Analytics | ✅ Live |
| Leaderboard API | ✅ Live |
| Admin Dashboard APIs | ✅ Live |
| Swagger / OpenAPI 3.0 Documentation | ✅ Live |
| PostgreSQL + Spring Data JPA Integration | ✅ Live |
| Docker & Docker Compose Support | ✅ Live |
| Global Exception Handling | ✅ Live |
| Input Validation (Bean Validation) | ✅ Live |
| Pagination & Sorting | ✅ Live |

---

## 🛠️ Tech Stack

```
Backend Framework  : Spring Boot 3.x
Language           : Java 17
Security           : Spring Security + JWT (JJWT)
Database           : PostgreSQL 15
ORM                : Spring Data JPA / Hibernate
Build Tool         : Maven
API Documentation  : Swagger / OpenAPI 3.0 (SpringDoc)
Containerization   : Docker + Docker Compose
Validation         : Jakarta Bean Validation
Testing            : JUnit 5 + Mockito
```

---

## 🏗️ System Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                        CLIENT (Web / Mobile)                    │
└──────────────────────────────┬──────────────────────────────────┘
                               │  HTTPS + JWT Bearer Token
┌──────────────────────────────▼──────────────────────────────────┐
│                    SPRING SECURITY FILTER CHAIN                 │
│          [ JWT Validation → Authentication → Authorization ]    │
└──────────────────────────────┬──────────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────────┐
│                       REST CONTROLLERS                          │
│    AuthController  │  UserController  │  QuestionController     │
│    AdminController │  LeaderboardController │  ModuleController │
└──────────────────────────────┬──────────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────────┐
│                        SERVICE LAYER                            │
│         Business Logic + Validation + DTO Mapping              │
└──────────────────────────────┬──────────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────────┐
│                      REPOSITORY LAYER                           │
│              Spring Data JPA + Custom JPQL Queries             │
└──────────────────────────────┬──────────────────────────────────┘
                               │
┌──────────────────────────────▼──────────────────────────────────┐
│                    PostgreSQL DATABASE                          │
│     users │ questions │ modules │ progress │ leaderboard        │
└─────────────────────────────────────────────────────────────────┘
```

---

## 📁 Project Structure

```
prepwise-backend/
│
├── src/
│   ├── main/
│   │   ├── java/com/prepwise/
│   │   │   ├── PrepwiseApplication.java
│   │   │   │
│   │   │   ├── config/
│   │   │   │   ├── SecurityConfig.java          # Spring Security + CORS config
│   │   │   │   ├── JwtConfig.java               # JWT secret, expiry settings
│   │   │   │   └── SwaggerConfig.java           # OpenAPI 3.0 configuration
│   │   │   │
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java          # /api/v1/auth/**
│   │   │   │   ├── UserController.java          # /api/v1/users/**
│   │   │   │   ├── CodingQuestionController.java
│   │   │   │   ├── AptitudeQuestionController.java
│   │   │   │   ├── ModuleController.java
│   │   │   │   ├── ProgressController.java
│   │   │   │   ├── LeaderboardController.java
│   │   │   │   └── AdminController.java
│   │   │   │
│   │   │   ├── service/
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── UserService.java
│   │   │   │   ├── QuestionService.java
│   │   │   │   ├── ProgressService.java
│   │   │   │   ├── LeaderboardService.java
│   │   │   │   └── JwtService.java
│   │   │   │
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── CodingQuestionRepository.java
│   │   │   │   ├── AptitudeQuestionRepository.java
│   │   │   │   ├── ProgressRepository.java
│   │   │   │   └── LeaderboardRepository.java
│   │   │   │
│   │   │   ├── model/
│   │   │   │   ├── User.java
│   │   │   │   ├── CodingQuestion.java
│   │   │   │   ├── AptitudeQuestion.java
│   │   │   │   ├── Module.java
│   │   │   │   ├── Progress.java
│   │   │   │   └── enums/
│   │   │   │       ├── Role.java                # USER, ADMIN
│   │   │   │       └── Difficulty.java          # EASY, MEDIUM, HARD
│   │   │   │
│   │   │   ├── dto/
│   │   │   │   ├── request/
│   │   │   │   │   ├── LoginRequest.java
│   │   │   │   │   ├── RegisterRequest.java
│   │   │   │   │   └── QuestionRequest.java
│   │   │   │   └── response/
│   │   │   │       ├── AuthResponse.java
│   │   │   │       ├── UserResponse.java
│   │   │   │       └── ApiResponse.java
│   │   │   │
│   │   │   ├── security/
│   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   ├── JwtTokenProvider.java
│   │   │   │   └── CustomUserDetailsService.java
│   │   │   │
│   │   │   └── exception/
│   │   │       ├── GlobalExceptionHandler.java
│   │   │       ├── ResourceNotFoundException.java
│   │   │       └── UnauthorizedException.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-dev.properties
│   │       └── application-prod.properties
│   │
│   └── test/
│       └── java/com/prepwise/
│           ├── AuthServiceTest.java
│           └── QuestionServiceTest.java
│
├── docker/
│   ├── Dockerfile
│   └── docker-compose.yml
│
├── .env.example
├── pom.xml
└── README.md
```

---

## 🔌 API Endpoints

### 🔐 Authentication

| Method | Endpoint | Auth Required | Description |
|--------|----------|:---:|-------------|
| `POST` | `/api/v1/auth/register` | ❌ | Register a new user |
| `POST` | `/api/v1/auth/login` | ❌ | Login and receive JWT tokens |
| `POST` | `/api/v1/auth/refresh` | ❌ | Refresh access token |
| `POST` | `/api/v1/auth/logout` | ✅ | Invalidate refresh token |

### 👤 User / Profile

| Method | Endpoint | Auth Required | Description |
|--------|----------|:---:|-------------|
| `GET` | `/api/v1/users/me` | ✅ USER | Get current user profile |
| `PUT` | `/api/v1/users/me` | ✅ USER | Update profile |
| `GET` | `/api/v1/users/{id}` | ✅ ADMIN | Get user by ID |
| `DELETE` | `/api/v1/users/{id}` | ✅ ADMIN | Delete user |

### 💻 Coding Questions

| Method | Endpoint | Auth Required | Description |
|--------|----------|:---:|-------------|
| `GET` | `/api/v1/questions/coding` | ✅ | List all (paginated, filterable) |
| `GET` | `/api/v1/questions/coding/{id}` | ✅ | Get question by ID |
| `POST` | `/api/v1/questions/coding` | ✅ ADMIN | Create question |
| `PUT` | `/api/v1/questions/coding/{id}` | ✅ ADMIN | Update question |
| `DELETE` | `/api/v1/questions/coding/{id}` | ✅ ADMIN | Delete question |

### 🧮 Aptitude Questions

| Method | Endpoint | Auth Required | Description |
|--------|----------|:---:|-------------|
| `GET` | `/api/v1/questions/aptitude` | ✅ | List all (paginated) |
| `GET` | `/api/v1/questions/aptitude/{id}` | ✅ | Get question by ID |
| `POST` | `/api/v1/questions/aptitude` | ✅ ADMIN | Create question |

### 📈 Progress Tracking

| Method | Endpoint | Auth Required | Description |
|--------|----------|:---:|-------------|
| `GET` | `/api/v1/progress/me` | ✅ USER | Get personal progress stats |
| `POST` | `/api/v1/progress/submit` | ✅ USER | Submit question attempt |
| `GET` | `/api/v1/progress/summary` | ✅ USER | Get summary analytics |

### 🏆 Leaderboard

| Method | Endpoint | Auth Required | Description |
|--------|----------|:---:|-------------|
| `GET` | `/api/v1/leaderboard` | ✅ | Get global leaderboard (paginated) |
| `GET` | `/api/v1/leaderboard/me` | ✅ USER | Get user's rank |

### 🛡️ Admin

| Method | Endpoint | Auth Required | Description |
|--------|----------|:---:|-------------|
| `GET` | `/api/v1/admin/users` | ✅ ADMIN | List all users |
| `GET` | `/api/v1/admin/stats` | ✅ ADMIN | Platform-wide stats |
| `PUT` | `/api/v1/admin/users/{id}/role` | ✅ ADMIN | Update user role |

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- **Java 17+** — [Download](https://adoptium.net/)
- **Maven 3.8+** — [Download](https://maven.apache.org/download.cgi)
- **PostgreSQL 15+** — [Download](https://www.postgresql.org/download/)
- **Docker & Docker Compose** *(optional)* — [Download](https://www.docker.com/)
- **Git** — [Download](https://git-scm.com/)

### Clone the Repository

```bash
git clone https://github.com/RathlavathAnil/prepwise-backend.git
cd prepwise-backend
```

---

## 🔧 Environment Variables

Copy the example environment file and configure your values:

```bash
cp .env.example .env
```

### `.env.example`

```env
# ─── Application ──────────────────────────────────────────────
APP_NAME=PrepWise
APP_PORT=8080
APP_ENV=dev

# ─── PostgreSQL Database ───────────────────────────────────────
DB_HOST=localhost
DB_PORT=5432
DB_NAME=prepwise_db
DB_USERNAME=prepwise_user
DB_PASSWORD=your_strong_password_here

# ─── JWT Configuration ─────────────────────────────────────────
JWT_SECRET=your_256bit_base64_encoded_secret_key_here
JWT_ACCESS_TOKEN_EXPIRY=900000         # 15 minutes in ms
JWT_REFRESH_TOKEN_EXPIRY=604800000     # 7 days in ms

# ─── Spring JPA ────────────────────────────────────────────────
JPA_DDL_AUTO=update
JPA_SHOW_SQL=false

# ─── Swagger ───────────────────────────────────────────────────
SWAGGER_ENABLED=true

# ─── CORS ──────────────────────────────────────────────────────
CORS_ALLOWED_ORIGINS=http://localhost:3000,http://localhost:5173
```

> ⚠️ **Never commit your `.env` file.** It is included in `.gitignore` by default.

---

## 🗄️ Database Configuration

### Create the PostgreSQL database manually

```bash
# Connect to PostgreSQL
psql -U postgres

# Create user and database
CREATE USER prepwise_user WITH PASSWORD 'your_strong_password_here';
CREATE DATABASE prepwise_db OWNER prepwise_user;
GRANT ALL PRIVILEGES ON DATABASE prepwise_db TO prepwise_user;
\q
```

### `application.properties` (references `.env` values)

```properties
spring.application.name=${APP_NAME}
server.port=${APP_PORT:8080}

# DataSource
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=${JPA_DDL_AUTO:update}
spring.jpa.show-sql=${JPA_SHOW_SQL:false}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true

# JWT
app.jwt.secret=${JWT_SECRET}
app.jwt.access-token-expiry=${JWT_ACCESS_TOKEN_EXPIRY:900000}
app.jwt.refresh-token-expiry=${JWT_REFRESH_TOKEN_EXPIRY:604800000}
```

---

## 💻 Running Locally

### 1. Install dependencies

```bash
mvn clean install -DskipTests
```

### 2. Run the application

```bash
mvn spring-boot:run
```

Or using the JAR directly:

```bash
mvn clean package -DskipTests
java -jar target/prepwise-backend-1.0.0.jar
```

### 3. Verify the server is running

```bash
curl http://localhost:8080/actuator/health
# Expected: {"status":"UP"}
```

### Available Maven Commands

```bash
mvn clean install          # Build and install dependencies
mvn spring-boot:run        # Run the application
mvn test                   # Run unit tests
mvn clean package          # Build JAR artifact
mvn clean package -DskipTests   # Build without running tests
mvn dependency:tree        # View dependency tree
```

---

## 🐳 Docker Deployment

### `Dockerfile`

```dockerfile
# ─── Stage 1: Build ───────────────────────────────────────────
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# ─── Stage 2: Run ─────────────────────────────────────────────
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/prepwise-backend-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

> This multi-stage Dockerfile keeps the final image lean — only the JRE and the compiled JAR are included in the production image.

### `docker-compose.yml`

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:15-alpine
    container_name: prepwise-db
    environment:
      POSTGRES_DB: ${DB_NAME}
      POSTGRES_USER: ${DB_USERNAME}
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    ports:
      - "${DB_PORT:-5432}:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U ${DB_USERNAME} -d ${DB_NAME}"]
      interval: 10s
      timeout: 5s
      retries: 5
    networks:
      - prepwise-network

  app:
    build: .
    container_name: prepwise-app
    depends_on:
      postgres:
        condition: service_healthy
    env_file:
      - .env
    environment:
      DB_HOST: postgres
    ports:
      - "${APP_PORT:-8080}:8080"
    networks:
      - prepwise-network
    restart: unless-stopped

volumes:
  postgres_data:

networks:
  prepwise-network:
    driver: bridge
```

### Docker Commands

```bash
# Build and start all services
docker-compose up --build

# Start in detached (background) mode
docker-compose up -d --build

# View live logs
docker-compose logs -f app

# Stop all containers
docker-compose down

# Stop and remove volumes (wipes DB data)
docker-compose down -v

# Rebuild only the app container
docker-compose up --build app
```

---

## 📖 API Documentation

PrepWise uses **Swagger UI (OpenAPI 3.0)** for interactive API documentation.

Once the server is running, open:

```
http://localhost:8080/swagger-ui.html
```

Or access the raw OpenAPI JSON spec at:

```
http://localhost:8080/v3/api-docs
```

### Swagger Features Available

- ✅ Explore all endpoints grouped by controller
- ✅ Test authenticated requests using the **Authorize** button (paste your JWT Bearer token)
- ✅ View request schemas, response models, and error codes
- ✅ Export OpenAPI spec for Postman or API gateway integration

### Screenshot Placeholder

```
┌─────────────────────────────────────────────────────────────┐
│                  Swagger UI — PrepWise API                  │
│─────────────────────────────────────────────────────────────│
│  [ Auth ]   POST /api/v1/auth/register                      │
│             POST /api/v1/auth/login                         │
│─────────────────────────────────────────────────────────────│
│  [ Users ]  GET  /api/v1/users/me                           │
│             PUT  /api/v1/users/me                           │
│─────────────────────────────────────────────────────────────│
│  [ Questions ] GET /api/v1/questions/coding?page=0&size=10  │
└─────────────────────────────────────────────────────────────┘
```

> 📸 *Add actual Swagger screenshots to `/docs/screenshots/` and link them here.*

---

## 🔒 Security

PrepWise implements a defense-in-depth security model:

### JWT Authentication Flow

```
1. Client sends credentials → POST /api/v1/auth/login
2. Server validates credentials against DB (BCrypt password hash)
3. Server issues: Access Token (15 min) + Refresh Token (7 days)
4. Client attaches Access Token to every request:
   Authorization: Bearer <access_token>
5. JwtAuthenticationFilter intercepts → validates token → sets SecurityContext
6. On expiry: client uses Refresh Token → POST /api/v1/auth/refresh
```

### Security Measures

| Layer | Implementation |
|---|---|
| Password hashing | BCrypt (strength 12) |
| Token signing | HMAC-SHA256 with 256-bit secret |
| Endpoint protection | Spring Security filter chain per-role |
| Input validation | Jakarta Bean Validation on all DTOs |
| SQL injection | Prevented via JPA parameterized queries |
| CORS | Configurable allowed origins via env |
| Error responses | Generic messages (no stack traces in prod) |

---

## 📦 API Response Examples

### ✅ Register — `POST /api/v1/auth/register`

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Rathlavath Anil",
    "email": "anil@example.com",
    "password": "SecurePass@2024"
  }'
```

**Response `201 Created`:**
```json
{
  "success": true,
  "message": "User registered successfully",
  "data": {
    "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
    "name": "Rathlavath Anil",
    "email": "anil@example.com",
    "role": "USER",
    "createdAt": "2026-05-18T10:30:00Z"
  }
}
```

---

### ✅ Login — `POST /api/v1/auth/login`

**Request:**
```bash
curl -X POST http://localhost:8080/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "anil@example.com",
    "password": "SecurePass@2024"
  }'
```

**Response `200 OK`:**
```json
{
  "success": true,
  "message": "Login successful",
  "data": {
    "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "tokenType": "Bearer",
    "expiresIn": 900
  }
}
```

---

### ✅ Get Coding Questions — `GET /api/v1/questions/coding`

**Request:**
```bash
curl -X GET "http://localhost:8080/api/v1/questions/coding?page=0&size=5&difficulty=MEDIUM&topic=arrays" \
  -H "Authorization: Bearer <your_access_token>"
```

**Response `200 OK`:**
```json
{
  "success": true,
  "data": {
    "content": [
      {
        "id": 1,
        "title": "Two Sum",
        "difficulty": "EASY",
        "topic": "Arrays",
        "tags": ["HashMap", "Arrays"],
        "companies": ["Amazon", "Google", "Microsoft"],
        "acceptanceRate": 49.2
      },
      {
        "id": 2,
        "title": "Longest Substring Without Repeating Characters",
        "difficulty": "MEDIUM",
        "topic": "Sliding Window",
        "tags": ["Sliding Window", "HashMap"],
        "companies": ["Amazon", "Bloomberg"],
        "acceptanceRate": 33.8
      }
    ],
    "currentPage": 0,
    "totalPages": 12,
    "totalElements": 58,
    "pageSize": 5
  }
}
```

---

### ✅ Get My Progress — `GET /api/v1/progress/me`

**Request:**
```bash
curl -X GET http://localhost:8080/api/v1/progress/me \
  -H "Authorization: Bearer <your_access_token>"
```

**Response `200 OK`:**
```json
{
  "success": true,
  "data": {
    "userId": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
    "totalSolved": 47,
    "easySolved": 22,
    "mediumSolved": 20,
    "hardSolved": 5,
    "aptitudeSolved": 35,
    "currentStreak": 8,
    "longestStreak": 14,
    "lastActiveAt": "2026-05-18T09:15:00Z"
  }
}
```

---

### ❌ Unauthorized Error

```json
{
  "success": false,
  "status": 401,
  "error": "Unauthorized",
  "message": "JWT token is expired or invalid",
  "timestamp": "2026-05-18T10:45:00Z",
  "path": "/api/v1/users/me"
}
```

---

### ❌ Validation Error

```json
{
  "success": false,
  "status": 400,
  "error": "Validation Failed",
  "details": {
    "email": "must be a valid email address",
    "password": "must be at least 8 characters"
  },
  "timestamp": "2026-05-18T10:45:00Z"
}
```

---

## 🔮 Future Enhancements

- [ ] **AI Mock Interviews** — Integrate LLM APIs for real-time interview simulation
- [ ] **Company-wise Question Filters** — Filter by Amazon, Google, Microsoft, etc.
- [ ] **Mock Test Engine** — Timed aptitude and coding assessments with auto-scoring
- [ ] **Email Notifications** — Streak reminders, weekly progress reports (Spring Mail)
- [ ] **Redis Caching** — Cache leaderboard and question lists for low-latency reads
- [ ] **Rate Limiting** — Per-user API rate limits using Bucket4j
- [ ] **WebSocket Support** — Real-time leaderboard updates
- [ ] **OAuth 2.0 / Google Login** — Social authentication support
- [ ] **CI/CD Pipeline** — GitHub Actions for automated testing and deployment
- [ ] **Kubernetes Manifests** — Helm charts for cloud-native deployment

---

## 🤝 Contributing

Contributions are welcome and appreciated! Here's how to get started:

### Steps

```bash
# 1. Fork the repository on GitHub

# 2. Clone your fork
git clone https://github.com/<your-username>/prepwise-backend.git
cd prepwise-backend

# 3. Create a feature branch
git checkout -b feature/your-feature-name

# 4. Make your changes and commit
git add .
git commit -m "feat: add your feature description"

# 5. Push to your fork
git push origin feature/your-feature-name

# 6. Open a Pull Request on GitHub
```

### Commit Convention

This project uses [Conventional Commits](https://www.conventionalcommits.org/):

| Prefix | Usage |
|---|---|
| `feat:` | New feature |
| `fix:` | Bug fix |
| `docs:` | Documentation update |
| `refactor:` | Code refactor (no feature/fix) |
| `test:` | Adding or updating tests |
| `chore:` | Build/config updates |

### Code Standards

- Follow standard Java naming conventions
- Add Javadoc comments to all public service methods
- Write unit tests for new service logic
- Run `mvn test` before submitting a PR

---

## 📄 License

This project is licensed under the **MIT License**.

```
MIT License

Copyright (c) 2026 Rathlavath Anil

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software...
```

See the full [LICENSE](LICENSE) file for details.

---

<div align="center">

**Built with ❤️ by [Rathlavath Anil](https://github.com/RathlavathAnil)**

[![GitHub](https://img.shields.io/badge/GitHub-RathlavathAnil-181717?style=flat-square&logo=github)](https://github.com/RathlavathAnil)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-rathlavathanil-0A66C2?style=flat-square&logo=linkedin)](https://linkedin.com/in/rathlavathanil)

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0ea5e9,100:6366f1&height=100&section=footer" width="100%"/>

</div>
