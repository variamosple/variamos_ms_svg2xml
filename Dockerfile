# Use an official Java runtime as a parent image
FROM openjdk:20-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file into the container at /app
COPY target/variamos_ms_svg2xml.jar /app/variamos_ms_svg2xml.jar

EXPOSE 8080

# Command to run when the container starts
CMD ["java", "-jar", "variamos_ms_svg2xml.jar"]