ARG PROJECT_ARTIFACT_ID=eloryks-authorization

FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml /app/pom.xml
COPY src /app/src
# Build JAR file
RUN mvn clean install && \
    cp /app/target/eloryks-authorization-1.0.0.jar /app/eloryks-authorization.jar

FROM eclipse-temurin:17-jre-focal AS runnable
WORKDIR /app
COPY /etc/application.properties /app/etc/application.properties
COPY --from=build /app/eloryks-authorization.jar ./
EXPOSE 8081
ENTRYPOINT ["java", "-Dspring.config.location=/app/etc/application.properties", "-jar", "/app/eloryks-authorization.jar"]
