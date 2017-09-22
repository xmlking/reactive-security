Reactive Security
=================
A simple demo application showcases reactive security.

##### Technology stack
* Spring Framework 5
* Spring Boot 2.0.0
* Spring WebFlux
* Gradle 4

##### Highlights
* Multi-project builds with Gradle Kotlin Script. 
* Kotlin as a language
* Cross-Origin Resource Sharing (CORS)
* Docker deployment


### Prerequisites
1. Gradle 4 (Install via [sdkman](http://sdkman.io/))
2. Docker for Mac [Setup Instructions](./docs/Docker.md)

### Build
```bash
# build all 3 executable jars
gradle build
# continuous build with `-t`. 
# this shoud be started before any run tasks i.e., `gradle ui-app:bootRun`, for spring's devtools to work.
gradle -t build
# build all 3 apps
gradle build -x test -x shared:build
# build all 3 docker images
gradle docker -x test -x shared:build
```

### Test
```bash
gradle test
```

### Run
##### Manual 
Start all 3 apps: [data-service](./data-service/), [auth-service](./auth-service/), [jwt-client](./jwt-client-js/)
> If you want to debug the app, add --debug-jvm parameter to Gradle command line

##### Docker
You can also build Docker images and run all via `Docker Compose`
```bash
# start containers in the background
docker-compose up -d
# start containers in the foreground
docker-compose up 
# show runnning containers 
docker-compose ps
# scaling containers and load balancing
docker-compose scale data-service=2
# 1. stop the running containers using
docker-compose stop
# 2. remove the stopped containers using
docker-compose rm -f
# start specific docker-compose file
docker-compose  -f docker-compose-all.yml up
# just start only a single service
docker-compose up mysql
# connect(ssh) to a service and run a command
docker-compose exec  mysql mysql --user=root --password demo
```
>Access UI App at http://localhost:8080


### Gradle Commands
```bash
# upgrade project gradle version
gradle wrapper --gradle-version 4.2 --distribution-type all
# gradle daemon status 
gradle --status
gradle --stop
# refresh dependencies
gradle build --refresh-dependencies
```
