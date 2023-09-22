FROM bellsoft/liberica-openjdk-alpine:17.0.2-9-x86_64

COPY target/posts-0.0.1-SNAPSHOT.jar /posts-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/posts-0.0.1-SNAPSHOT.jar"]