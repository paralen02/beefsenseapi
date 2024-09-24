# Use a distroless base image with Java 17 (Debian 11)
FROM gcr.io/distroless/java17-debian11 AS runtime

# Create the application directory
WORKDIR /app

# Copy the JAR file into the container's working directory
COPY target/beefsenseapi-0.0.1-SNAPSHOT.jar /app/app.jar

# Copy the service account credentials to the specific path that Spring Boot expects
# This will automatically create the required directories
COPY src/main/resources/beefsenseapp-f1d007644db8.json /app/src/main/resources/beefsenseapp-f1d007644db8.json

# Expose the application port
EXPOSE 8080

# Set the entry point to start the Java application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
