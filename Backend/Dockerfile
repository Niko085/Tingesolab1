FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} Gestor-de-reparaciones.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","./Gestor-de-reparaciones.jar"]