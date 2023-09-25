FROM openjdk:22-jdk-bullseye
VOLUME /workspaces/javamicroservices
ADD target/javamicroservices-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]