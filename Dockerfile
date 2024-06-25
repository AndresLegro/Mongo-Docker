FROM openjdk:21-slim

LABEL maintainer="Andres Legro <andreslegrog@gmail.com>"

COPY target/Mongo-Docker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

