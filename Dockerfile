FROM gradle:9.5.0-jdk25@sha256:03305b464e024b29cfaad1c4a41fed61d06d15453176d2180f65bd4358b789a6 AS build

WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle -i --stacktrace clean build shadowJar

FROM eclipse-temurin:25.0.3_9-jdk@sha256:e23592541431eaeef5c13c84c21db71f97cdca0e70181ea6222ec9bccac24f6c

WORKDIR /opt/analyzer
COPY bin/run.sh bin/run.sh
COPY --from=build /app/build/libs/java-analyzer.jar .

ENTRYPOINT ["sh", "/opt/analyzer/bin/run.sh"]
