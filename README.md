# Java-Selenium-Automation-Tests

This framework is an end-to-end testing for **Amazon e-commerce** using Java/Selenium.

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 8](https://openjdk.java.net/projects/jdk8/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)


## Getting Started


## Running tests ##

Note: The only browsers available to run are:
```console
chrome (default)
edge
firefox
```

### - Running locally 

- Run all tests passing browser as a parameter. The localhost is default `-DHOST=host.localhost`

```console
$  mvn clean test -DBROWSER=chrome
$  mvn clean test -DBROWSER=edge
$  mvn clean test -DBROWSER=firefox
```

### - Running using Selenium Grid 

- Build docker-compose

```console
$ docker-compose -f docker-compose.yml up -d
```

- Launch the selenium-grid

```console
$ http://localhost:4444
```

- Run the tests passing `-DHOST=host.docker.selenium.grid`

```console
$  mvn clean test -DBROWSER=chrome -DHOST=host.docker.selenium.grid
$  mvn clean test -DBROWSER=edge -DHOST=host.docker.selenium.grid
$  mvn clean test -DBROWSER=firefox -DHOST=host.docker.selenium.grid
```

### - Running using Docker

Dockerfile was obtained through [Docker Hub site](https://hub.docker.com/_/maven).


- Build Dockerfile and run all tests in docker container

```console
$  docker build .
```

- Once container is created, the tests can be run by using the existing `image(tag)` regarding the previous execution

```console
$  
$  docker run -i -t <image_id> /bin/bash
$  mvn clean test -DBROWSER=chrome -DHEADLESS=true
```

- Removing images

```console
$  docker image ls
$  docker rmi -f <image_id>
```
