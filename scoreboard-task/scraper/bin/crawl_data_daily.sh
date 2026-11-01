#!/bin/sh
set -e

echo "Begin crawl new matches infos"
cd /app
java -cp "lib/*" azeroth.ScoreboardCrawler

echo "Update raw matches infos"
psql -f /app/scripts/01_get_daily_matches.sql

echo "End crawl new matches infos"

