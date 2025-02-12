# Use the official OpenJDK 17 slim image as base
FROM openjdk:17-slim

# Set environment variables
ENV TZ=America/Sao_Paulo
ENV JAVA_TOOL_OPTIONS="-javaagent:/opentelemetry-javaagent.jar"

# Set the timezone
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Download OpenTelemetry Java Agent
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar



# Copy the executable
COPY /target/*.jar /usr/app/app.jar

# Set working directory
WORKDIR /app

# Expose the application port (adjust if needed)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/target/ms-validador-jwt-1.0.1-SNAPSHOT.jar"]