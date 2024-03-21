FROM maven:latest AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


FROM openjdk:21-slim AS runtime

WORKDIR /app

COPY --from=build /app/target/*.jar app/app.jar

CMD ["java", "-jar", "app/app.jar"]
