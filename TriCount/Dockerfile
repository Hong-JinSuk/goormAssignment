FROM openjdk:17

#ARG JAR_FILE=build/libs/*.jar
#
#COPY ${JAR_FILE} app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]

WORKDIR /app

COPY build/libs/TriCount-0.0.1-SNAPSHOT.jar /app/TriCount-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/app/TriCount-0.0.1-SNAPSHOT.jar"]