#!/bin/bash

# Usage:
# ./bin/analyze.sh two_fer ~/test/

./gradlew run -q -Pargs="$1 $2"
