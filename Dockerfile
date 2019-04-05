FROM gradle:jdk-alpine

USER root

COPY . ./
RUN gradle installDist --stacktrace

FROM openjdk:8-jre-alpine

RUN mkdir -p /opt/analyzer

COPY build/install/java-analyzer/ /opt/analyzer
WORKDIR /opt/analyzer

ENTRYPOINT ["java", "-classpath", "lib/*", "analyzer.Main"]
