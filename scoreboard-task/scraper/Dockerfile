# ---- Build stage ----
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle* settings.gradle* ./
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon || true

COPY src src
RUN ./gradlew installDist --no-daemon -x test


# ---- Run stage ----
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN apk add --no-cache postgresql-client
RUN addgroup -S app && adduser -S app -G app
COPY --from=build /app/build/install/*/lib/ ./lib/
COPY --chown=app:app --chmod=755 bin/crawl_data_daily.sh ./bin/crawl_data_daily.sh
COPY --chown=app:app scripts ./scripts
USER app

ENTRYPOINT ["java", "-cp", "lib/*", "azeroth.ScoreboardCrawler"]