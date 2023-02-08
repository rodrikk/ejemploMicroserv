FROM openjdk:17
ADD target/Eje-0.0.1-SNAPSHOT.jar Eje-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Eje-0.0.1-SNAPSHOT.jar"]