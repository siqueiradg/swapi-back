FROM adoptopenjdk/openjdk11:alpine
RUN apk --no-cache add curl
VOLUME /tmp
EXPOSE 8080
ADD target/swapi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
