FROM openjdk:21-jdk-slim AS build-with-dependencies
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle build.gradle settings.gradle /home/gradle/src/
RUN ./gradlew downloadDependencies --no-daemon > /dev/null 2>&1 || true

FROM build-with-dependencies AS build
COPY --chown=gradle:gradle . /home/gradle/src
RUN ./gradlew build --no-daemon -x test

FROM openjdk:21-jdk-slim
EXPOSE 8080
RUN mkdir -p /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/application.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/application.jar"]