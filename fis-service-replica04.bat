@echo off
TITLE fis-service-replica04: http://localhost:6114
java -jar -Dspring.profiles.active=fis-service-replica04 FISService-0.0.1-SNAPSHOT.jar