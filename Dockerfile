FROM openjdk:17
ADD target/inventory-service.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
