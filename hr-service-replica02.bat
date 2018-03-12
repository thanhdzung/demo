@echo off
TITLE hr-service-replica02: http://localhost:6202
java -jar -Dspring.profiles.active=hr-service-replica02 HRService-0.0.1-SNAPSHOT.jar