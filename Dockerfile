FROM gradle:jdk-alpine

USER root

RUN apk add bash

RUN adduser -D -g '' java-analyzer
RUN mkdir -p /opt/analyzer

COPY . /opt/analyzer
WORKDIR /opt/analyzer

RUN gradle installDist --stacktrace
RUN chown -R java-analyzer /opt/analyzer

USER java-analyzer
