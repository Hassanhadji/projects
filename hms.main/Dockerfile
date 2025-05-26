# Use a base image with Gradle and JDK 17 installed
FROM gradle:8.3-jdk17 AS build
WORKDIR /app
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src ./src
RUN gradle clean bootJar

# Create the final image based on OpenJDK 17
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/hmspms.jar ./hmspms.jar
EXPOSE 8080
CMD ["java", "-jar", "hmspms.jar"]