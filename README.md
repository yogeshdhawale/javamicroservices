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

---
build and release


 ./mvnw spring-boot:build-image