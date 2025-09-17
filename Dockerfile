FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.war app.war
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.war"]