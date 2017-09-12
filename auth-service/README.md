Auth Service
============
OAuth Server

##### Technology stack
* Spring Boot 2.0.0
* Integration tests with Docker Compose

##### Features
* Functional Style Routes
* CORS Enabled 
* Dockerized 

### Run
> use `./gradlew` instead of `gradle` if you didn't installed `gradle`
```bash
gradle auth-service:bootRun
# run with `docker` profile.
SPRING_PROFILES_ACTIVE=docker gradle auth-service:bootRun
```
### Test
```bash
gradle auth-service:test
```
### Build
```bash
gradle auth-service:build
# skip test
gradle auth-service:build -x test 
# build docker image
gradle data-service:auth -x test 
```

### Deploy
> deploying app to mesos
```bash
# tag and puch to data-service
docker tag reactive-security/auth-service:0.1.0-SNAPSHOT reactive-security/auth-service:latest
docker login 
docker push reactive-security/auth-service:0.1.0-SNAPSHOT
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
