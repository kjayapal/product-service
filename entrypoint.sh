#!/bin/bash
#
# docker-entrypoint for service

set -e

echo "Executing java ${JAVA_ARGS} "$@""
java ${JAVA_ARGS} -jar product-service-0.0.5.jar