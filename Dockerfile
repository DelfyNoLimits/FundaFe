FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} docker-spring-boot.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot.jar"]