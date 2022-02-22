FROM maven:3.8-openjdk-17 AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:17-alpine3.14
COPY --from=build /app/target/ArangoCatProject-0.0.1-SNAPSHOT.jar /ArangoCatProject-0.0.1-SNAPSHOT.jar
#COPY target/ArangoCatProject-0.0.1-SNAPSHOT.jar /ArangoCatProject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/ArangoCatProject-0.0.1-SNAPSHOT.jar"]