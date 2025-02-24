# 1️⃣ Utilise l’image OpenJDK 21
FROM openjdk:21-jdk-slim

# 2️⃣ Définit le répertoire de travail
WORKDIR /app

# 3️⃣ Copie le JAR généré
COPY target/*.jar app.jar

# 4️⃣ Expose le port utilisé par Spring Boot
EXPOSE 5000

# 5️⃣ Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
