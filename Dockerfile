# Use a Maven image to build the application
FROM maven:3.9.9-amazoncorretto-17-al2023 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a minimal Debian-based image with OpenJDK 17
FROM openjdk:17-slim AS runtime

# Install necessary packages
RUN apt-get update && apt-get install -y libstdc++6

# Create the application directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/beefsenseapi-0.0.1-SNAPSHOT.jar /app/app.jar

# Create the directories that Spring Boot is looking for
RUN mkdir -p /app/src/main/resources/saved3/1

# Copy the TensorFlow model and labels to the specific path that Spring Boot expects
COPY src/main/resources/saved3/1 /app/src/main/resources/saved3/1

# Copy the service account credentials to the specific path that Spring Boot expects
COPY src/main/resources/beefsenseapp-f1d007644db8.json /app/src/main/resources/beefsenseapp-f1d007644db8.json

# Expose the application port
EXPOSE 8080

# Set the entry point to start the Java application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
