FROM openjdk:17-jdk-alpine
ENV APP_HOME=/app
WORKDIR $APP_HOME
EXPOSE 8081
COPY target/Airlines-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
