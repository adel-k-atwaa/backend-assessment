#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#COPY ./*.jar app.jar
#ENTRYPOINT ["java","-jar","./app.jar"]
# Use an OpenJDK base image with Maven installed
FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app

# Copy the source code and pom.xml into the container
COPY src/ /app/src
COPY pom.xml /app/pom.xml

# Build the Spring Boot application
RUN mvn -f /app/pom.xml clean package

# Set up the image for running the application
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
RUN echo cd /app/target/ && ls -la
# Command to execute the JAR
CMD ["java", "-jar", "app.jar"]
