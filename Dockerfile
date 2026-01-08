# Stage 1: Build the application
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
COPY . .
# Ensure gradlew is executable
RUN chmod +x gradlew
# Build the application, skipping tests to speed up the process
RUN ./gradlew build -x test

# Stage 2: Run the application
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/build/libs/todo-list-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
