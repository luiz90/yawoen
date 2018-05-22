FROM java:8
VOLUME /tmp
ADD target/data-integration-1.0.0.jar yawoen.jar
EXPOSE 8080
RUN bash -c ‘touch /yawoen.jar’
ENTRYPOINT [“java”,”-Dspring.data.mongodb.uri=mongodb://mongo/test”, “-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/app.jar”]