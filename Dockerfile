FROM gradle:8.5.0-jdk21-alpine AS build-with-dependencies
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle build.gradle settings.gradle /home/gradle/src/
RUN gradle downloadDependencies --no-daemon > /dev/null 2>&1 || true

FROM build-with-dependencies AS build
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build --no-daemon -x test

FROM openjdk:21-jdk-slim
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/springboot3-with-graphql-0.0.1-SNAPSHOT.jar /app/application.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/application.jar"]