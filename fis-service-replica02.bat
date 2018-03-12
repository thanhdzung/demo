@echo off
TITLE fis-service-replica02: http://localhost:6112
java -jar -Dspring.profiles.active=fis-service-replica02 FISService-0.0.1-SNAPSHOT.jar