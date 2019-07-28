# Description off the project

This to-do app uses react and redux.
This is the front-end part.
You can access the back-end part : 
https://github.com/canavdan/React-Redux-Todo

In this project :
- You can add new to-do list and to-do item,
- You can mark as completed,
- You can remove todos or filter todos
- You can register and login.

## Techs

- Spring Boot 
- JWT
- JPA
- H2
- REST API

# Getting started

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Build
 * Build application (only unit tests)
 
```mvn clean install```

## Running the application locally

You can execute the `main` method from your IDE.

Another way is you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## API Reference

Todo API/Services are accessible at :
```
localhost:8080/api/v1/todolist**
