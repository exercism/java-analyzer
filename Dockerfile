FROM gradle:7.2-jdk8 as build

COPY --chown=gradle:gradle . .
RUN gradle installDist --stacktrace

FROM openjdk:8-jre-alpine

RUN mkdir -p /opt/analyzer

COPY --from=build /home/gradle/build/install/gradle /opt/analyzer
COPY bin/analyze.sh /opt/analyzer/bin

WORKDIR /opt/analyzer

ENTRYPOINT ["/opt/analyzer/bin/analyze.sh"]
