FROM openjdk:21
WORKDIR /app
COPY target/demo-1.0-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]