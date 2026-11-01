# ---- Build stage ----
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle* settings.gradle* ./
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon || true

COPY src src
RUN ./gradlew clean bootJar --no-daemon -x test


# ---- Run stage ----
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar
RUN apk add --no-cache postgresql-client
COPY --chmod=755 bin/build_data_daily.sh /app/bin/build_data_daily.sh
COPY scripts /app/scripts


EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
