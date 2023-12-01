FROM gradle:8.5-jdk8 as build

WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle -i --stacktrace clean build shadowJar

FROM openjdk:8-jre-alpine

WORKDIR /opt/analyzer
COPY bin/run.sh bin/run.sh
COPY --from=build /app/build/libs/java-analyzer.jar .

ENTRYPOINT ["sh", "/opt/analyzer/bin/run.sh"]
