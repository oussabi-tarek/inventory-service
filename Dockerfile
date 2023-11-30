#
# Build stage
FROM openjdk:17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN apt-get update && \
    apt-get install -y maven
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/spring_rest_docker.jar"]