FROM maven:3.9.0-eclipse-temurin-19 AS build
COPY src /app/src/
COPY pom.xml /app/
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:19-jre-alpine
COPY --from=build /app/target/postservicews-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app/postservicews-0.0.1-SNAPSHOT.jar"]
