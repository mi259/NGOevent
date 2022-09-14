
FROM openjdk:8-jdk-alpine
ADD target/NGOevent-0.0.1-SNAPSHOT.war NGOevent-0.0.1-SNAPSHOT.war
ENTRYPOINT ["sh", "-c", "java -jar /NGOevent-0.0.1-SNAPSHOT.war"]





