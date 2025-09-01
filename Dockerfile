FROM gradle:9.0-jdk21 AS build

WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle -i --stacktrace clean build shadowJar

FROM eclipse-temurin:21

WORKDIR /opt/analyzer
COPY bin/run.sh bin/run.sh
COPY --from=build /app/build/libs/java-analyzer.jar .

ENTRYPOINT ["sh", "/opt/analyzer/bin/run.sh"]
