@echo off
TITLE fis-service-replica03: http://localhost:6113
java -jar -Dspring.profiles.active=fis-service-replica03 FISService-0.0.1-SNAPSHOT.jar