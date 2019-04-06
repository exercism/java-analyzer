FROM gradle:jdk-alpine

USER root

COPY . ./
RUN gradle installDist --stacktrace

FROM openjdk:8-jre-alpine

RUN mkdir -p /opt/analyzer

COPY build/install/java-analyzer/ /opt/analyzer
COPY bin/analyze.sh /opt/analyzer/bin

WORKDIR /opt/analyzer

ENTRYPOINT ["./bin/analyze.sh"]
