@echo off
TITLE fis-service-replica01: http://localhost:6111
java -jar -Dspring.profiles.active=fis-service-replica01 FISService-0.0.1-SNAPSHOT.jar