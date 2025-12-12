# Stage 1: Build
FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source
COPY src ./src

# Builder l'application
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copier le JAR depuis le stage de build
COPY --from=build /app/target/*.jar app.jar

# Expose le port utilisé par Render
EXPOSE 8080

# Lancer l'application et envoyer les logs vers stdout
ENTRYPOINT ["java", "-jar", "app.jar"]
