FROM amazoncorretto:11-alpine as build
WORKDIR /workspace/app

COPY gradle gradle
COPY src src
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .

RUN --mount=type=cache,target=/root/.gradle ./gradlew build -x test

FROM amazoncorretto:11-alpine
EXPOSE 8080
WORKDIR /app/workspace
COPY --from=build /workspace/app/build/libs/grafana-showcase-0.1.jar app.jar
COPY opentelemetry-javaagent.jar otel-agent.jar
ENTRYPOINT ["java","-javaagent:otel-agent.jar",\
        #"-Dotel.service.name=api-service","-Dotel.traces.exporter=jaeger",\
        #"-Dotel.exporter.jaeger.endpoint=http://tempo:14250",\
        "-jar","app.jar"]

