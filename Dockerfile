from openjdk:19-alpine

COPY ./target/patterns-0.0.1-SNAPSHOT.jar /app/patterns-0.0.1-SNAPSHOT.jar
WORKDIR /app

ARG mailtrap_username
ARG mailtrap_password

ENV MAILTRAP_USERNAME=$mailtrap_username
ENV MAILTRAP_PASSWORD=$mailtrap_password

ENTRYPOINT ["java", "-jar", "patterns-0.0.1-SNAPSHOT.jar", "log.txt", "test@test.com", "error"]
EXPOSE 8080