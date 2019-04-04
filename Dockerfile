FROM gradle:jdk-alpine

USER root

RUN apk add bash

RUN mkdir -p /opt/analyzer

COPY . /opt/analyzer
WORKDIR /opt/analyzer

RUN gradle installDist --stacktrace

ENTRYPOINT ["./bin/analyze.sh"]
