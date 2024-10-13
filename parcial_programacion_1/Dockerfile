# Base image for metadata
FROM ubuntu:latest
LABEL authors="Eros"

# Build stage
FROM alpine:latest as build

RUN apk update
RUN apk add openjdk17

COPY build/libs/parcial_programacion_1-0.0.1-SNAPSHOT.jar  parcial_programacion_1
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

# Runtime stage
FROM openjdk:17-alpine
EXPOSE 8080
COPY --from=build /build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]