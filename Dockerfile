FROM openjdk:8-alpine
ARG JAR_FILE
ADD target/${JAR_FILE} order-api-code-challenge.jar
ENTRYPOINT ["java", "-jar", "order-api-code-challenge.jar"]
