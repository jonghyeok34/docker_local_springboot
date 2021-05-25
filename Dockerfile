FROM gradle:7.0.2-jdk8 AS build
# copy build.gradle, settings.gradle, src
COPY build.gradle .
COPY settings.gradle .
COPY src src

# gradle boot jar
ARG ENVIRONMENT
RUN gradle -Pprofile=${ENVIRONMENT} bootjar


FROM openjdk:8-jre-slim

ARG ENVIRONMENT
ENV SPRING_PROFILES_ACTIVE=${ENVIRONMENT}
ENV SYSTEM_ENV=${ENVIRONMENT}

EXPOSE 8082

RUN mkdir /app

# excute java & run spring boot by jar
COPY --from=build /home/gradle/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-Doracle.jdbc.timezoneAsRegion=false", "-Dfile.encoding=UTF-8", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]