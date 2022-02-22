FROM maven:3.8.4-jdk-8 AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /app/target/ArangoCatProject-0.0.1.jar /ArangoCatProject-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/ArangoCatProject-0.0.1.jar"]