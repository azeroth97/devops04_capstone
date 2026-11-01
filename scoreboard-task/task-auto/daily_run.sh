#!/bin/sh
set -e

BASE_DIR="/home/ubuntu/docker-compose"
cd "$BASE_DIR"

# Colors (only when stdout is a TTY)
if [ -t 1 ]; then
  BOLD=$(printf '\033[1m')
  RED=$(printf '\033[31m')
  GREEN=$(printf '\033[32m')
  YELLOW=$(printf '\033[33m')
  CYAN=$(printf '\033[36m')
  RESET=$(printf '\033[0m')
else
  BOLD=""; RED=""; GREEN=""; YELLOW=""; CYAN=""; RESET=""
fi

step_start() { printf '%s%sSTEP %s: %s%s\n' "$BOLD" "$CYAN" "$1" "$2" "$RESET"; }
step_end()   { printf '%s%sEND STEP %s%s\n\n' "$BOLD" "$GREEN" "$1" "$RESET"; }

trap 'printf "%s%sFAILED (exit code $?)%s\n" "$BOLD" "$RED" "$RESET"' EXIT

step_start 1 "CRAWL DATA"
docker compose run --rm --entrypoint /app/bin/crawl_data_daily.sh scraper
step_end 1

step_start 2 "BUILD DATA"
docker exec scoreboard_be /app/bin/build_data_daily.sh
step_end 2

trap - EXIT
printf '%s%sALL STEPS COMPLETED%s\n' "$BOLD" "$GREEN" "$RESET"