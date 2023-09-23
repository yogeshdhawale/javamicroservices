FROM openjdk:8-jdk-alpine
VOLUME /workspaces/javamicroservices
ADD build/libs/javamicroservices-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]