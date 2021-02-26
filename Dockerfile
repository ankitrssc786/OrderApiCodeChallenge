FROM openjdk:8-alpine
ARG JAR_FILE
ADD target/${JAR_FILE} OrderApiCodeChallenge.jar
ENTRYPOINT ["java", "-jar", "app.jar"]