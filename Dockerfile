FROM openjdk:21
EXPOSE 8080
WORKDIR /app
COPY ./target/candidate.arda.onur-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]