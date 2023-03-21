FROM maven:3.9.0

ADD target/arbeit-0.0.1-SNAPSHOT.jar application.jar

ENTRYPOINT ["java", "-jar","application.jar"]
EXPOSE 8080