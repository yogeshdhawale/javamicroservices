# javamicroservices


https://www.linkedin.com/learning/creating-your-first-spring-boot-microservice/introduction-to-spring-initialzr?autoSkip=true&resume=false

Mary Ellen Bowman 


ecApplication

explore california

backpack cali

features - mvn



https://explorecalifornia.org/tours.htm

...

		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-browser</artifactId>
		</dependency>

http://localhost:8080/browser/index.html#/


rm -rf ~/.m2/repository
cd <working dir>
mvn clean install -U


*** mongodb

replace spring data jpa with mongo

docker pull mongo
docker run -d  --name mongo-on-docker  -p 27017:27017 -p 27888:27888 -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret --authenticationDatabase  "appdb"  mongo


show dbs
show collections
show tables

docker-compose -f docker-compose-mongo.yml  up app_db -d

*** mysql
docker run --detach --name mysql_db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=app_db -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -d mysql


---
build and release

application run:
	./mvnw spring-boot:run
build docker image
	./mvnw spring-boot:build-image -DskipTests=true
		docker.io/library/javamicroservices:0.0.1-SNAPSHOT
	./mvnw spring-boot:build-image -DskipTests=true -Dspring-boot.build-image.imageName=myapp_jms:latest

mvn package -DskipTests=true
mvn package -DskipTests=true docker:build - needs plugin docker-maven-plugin


Dockerfile
	FROM openjdk:8-jdk-alpine
	VOLUME /workspaces/javamicroservices
	ADD target/javamicroservices-0.0.1-SNAPSHOT.jar app.jar
	EXPOSE 8080
	ENTRYPOINT ["java", "-jar","/app.jar"]
docker build -t java_ms_app . 
