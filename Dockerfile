FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java","-jar","target/SecondLoizBootSpringDemo-0.0.1-SNAPSHOT.jar"]