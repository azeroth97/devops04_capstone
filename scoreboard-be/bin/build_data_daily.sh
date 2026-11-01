#!/bin/sh
set -e

echo "Begin Step 1: Get new matches infos"
psql -f /app/scripts/01_get_new_match_results.sql
echo "End Step 1"

echo "Begin Step 2: Build ranking table"
psql -f /app/scripts/02_update_new_standings.sql
echo "End Step 2"