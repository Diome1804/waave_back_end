# Stage 1: Build
FROM maven:3.9-eclipse-temurin-17-alpine AS build

# Définir l'encodage UTF-8
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8
ENV MAVEN_OPTS="-Dfile.encoding=UTF-8 -Dproject.build.sourceEncoding=UTF-8"

WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source
COPY src ./src

# Builder l'application
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine

ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

WORKDIR /app

# Copier le JAR depuis le stage de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]