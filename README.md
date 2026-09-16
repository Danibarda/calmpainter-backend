# CalmPainter Backend

Backend for CalmPainter – a painting game built with Spring Boot and MongoDB. Exposes a REST API for game logic and a WebSocket endpoint for real-time updates.

**Live demo:** [calmpainter-frontend-e3f6o.ondigitalocean.app](https://calmpainter-frontend-e3f6o.ondigitalocean.app/)

## Tech Stack

- Java 21
- Spring Boot 4.1
- Spring Web (REST)
- Spring WebSocket (STOMP)
- Spring Data MongoDB
- Maven

## Getting Started

### Requirements

- JDK 21
- A MongoDB instance (e.g. MongoDB Atlas)

### Configuration

Copy or rename `.env.example` to `.env` and fill in your values:

```
SPRING_MONGODB_URI=your_mongodb_uri
CORS_ALLOWED_ORIGIN=http://localhost:5173
```

### Run the project

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

### Run tests

```bash
./mvnw test
```

### Build and run with Docker

```bash
docker build -t calmpainter-backend .
docker run -p 8080:8080 --env-file .env calmpainter-backend
```


### WebSocket

STOMP endpoint is available at `/websocket`, with a message broker at `/topic` and application prefix `/app`.

