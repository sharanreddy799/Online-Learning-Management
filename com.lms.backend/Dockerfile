# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jre-slim

# Set the working directory
WORKDIR /app

# Copy the war file to the container
COPY target/*.war /app/*.war

# Expose the application port
EXPOSE 3030

# Run the application
ENTRYPOINT ["java", "-jar", "your-application.war"]
