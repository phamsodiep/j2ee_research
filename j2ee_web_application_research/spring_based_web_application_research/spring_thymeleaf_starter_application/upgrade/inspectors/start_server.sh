#!/bin/bash
java -jar -Dspring.servlet.multipart.max-file-size=32MB -Dspring.servlet.multipart.max-request-size=32MB target/thymeleaf-skeleton-0.0.2-SNAPSHOT.jar
