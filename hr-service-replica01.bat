@echo off
TITLE hr-service-replica01: http://localhost:6201
java -jar -Dspring.profiles.active=hr-service-replica01 HRService-0.0.1-SNAPSHOT.jar