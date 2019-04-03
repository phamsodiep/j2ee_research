#!/bin/bash
POMVERSION=00
if [ -n "$1" ]; then
  POMVERSION=$1
fi
cp upgrade/google_app_engine/gae-pom-$POMVERSION.xml .
cp -r upgrade/google_app_engine/src .
