FROM openjdk:8
MAINTAINER sam.p.hurd@vanderbilt.edu
ADD /build/libs/myapplication-0.0.1-SNAPSHOT.war /app/jhipster-project/
WORKDIR /app/jhipster-project/
EXPOSE 8080
CMD java -jar myapplication-0.0.1-SNAPSHOT.war --spring.profiles.active=dev,swagger