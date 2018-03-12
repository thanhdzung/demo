@echo off
TITLE fsoft-service-replica01: http://localhost:6101
java -jar -Dspring.profiles.active=fsoft-service-replica01 FsoftService-0.0.1-SNAPSHOT.jar