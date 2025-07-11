# 1. Use Maven to build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Run the jar with a lighter image
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 5252
ENTRYPOINT ["java", "-jar", "app.jar"]


#Command to run docker
#docker build -t banke-app .
#docker run -p 5252:5252 banke-app
