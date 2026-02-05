# ===== Build =====
FROM maven:3.9.7-eclipse-temurin-21 AS build
WORKDIR /build

COPY pom.xml .
RUN mvn -q -B -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q -B -DskipTests package


# ===== Run =====
FROM eclipse-temurin:21-jre

ENV JAVA_OPTS="\
  -XX:+UseContainerSupport \
  -XX:MaxDirectMemorySize=1g \
  -XX:+ExitOnOutOfMemoryError \
"

WORKDIR /app
COPY --from=build /build/target/quarkus-app ./quarkus-app

EXPOSE 8080

# No dump directory needed; system OOM bypasses JVM handlers
RUN chown -R nobody:nogroup /app
USER nobody

ENTRYPOINT ["sh","-c","exec java $JAVA_OPTS -jar quarkus-app/quarkus-run.jar"]
