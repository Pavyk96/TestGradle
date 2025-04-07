FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/TestGradle-0.0.1-SNAPSHOT.jar /app/TestGradle.jar

ENTRYPOINT ["java", "-jar", "/app/TestGradle.jar"]
