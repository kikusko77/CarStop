ARG PROJECT_ARTIFACT_ID=eloryks-authorization

FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml /app/pom.xml
COPY src /app/src
RUN mvn clean package -DskipTests && \
    cp /app/target/eloryks-authorization-1.0.0.jar /app/eloryks-authorization.jar

FROM eclipse-temurin:17-jre-focal AS runnable
WORKDIR /app
COPY --from=build /app/eloryks-authorization.jar ./
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/eloryks-authorization.jar"]
