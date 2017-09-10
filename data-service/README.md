Data Service
============
App Data API

##### Technology stack
* Spring Boot 2.0.0
* Spring WebFlux
* Integration tests with Docker Compose

##### Features
* Functional Style Routes
* CORS Enabled 
* Dockerized 

### Run
> use `./gradlew` instead of `gradle` if you didn't installed `gradle`
```bash
gradle data-service:bootRun
# run with `docker` profile.
SPRING_PROFILES_ACTIVE=docker gradle data-service:bootRun
```
### Test
```bash
gradle data-service:test
```
### Build
```bash
gradle data-service:build
# skip test
gradle data-service:build -x test 
# build docker image
gradle data-service:docker -x test 
```

### Deploy
> deploying app to mesos
```bash
# tag and puch to data-service
docker tag reactive-security/data-service:0.1.0-SNAPSHOT reactive-security/data-service:latest
docker login 
docker push reactive-security/data-service:0.1.0-SNAPSHOT
```

### API

#### Local API 
* http://localhost:8080/api/guestbook
* http://localhost:8080/api/guestbook/Jack%20Bauer
* http://localhost:8080/api/guestbook/name/Jack%20Bauer
* http://localhost:8081/api/users
* http://localhost:8081/api/users/rob/principal
* http://localhost:8081/api/users/admin

##### EventSource API
* http://localhost:8080/sse/guestbook/Sumo

### Ref
* http://docs.spring.io/spring-data/cassandra/docs/current/reference/html/
