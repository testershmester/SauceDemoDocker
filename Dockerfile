# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11 AS build
# Set the working directory in the container
WORKDIR /tests
# Copy source project code and pom.xml
COPY pom.xml .
# Copy the entire project source code
COPY src ./src
# Download the project dependencies specified in the pom.xml
RUN mvn dependency:go-offline -B
#RUN tests
RUN mvn clean compile