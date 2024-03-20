# Use the official OpenJDK 17 image as the base image
FROM openjdk:17 AS api

# Copy the JAR file from the local filesystem into the container's /api directory
COPY ./target/ProjektPraksa-0.0.1-SNAPSHOT.jar ./api.jar

# Specify the entry point for the container to run your Java application
ENTRYPOINT ["java", "-jar", "api.jar"]
