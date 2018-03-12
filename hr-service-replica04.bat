@echo off
TITLE hr-service-replica04: http://localhost:6204
java -jar -Dspring.profiles.active=hr-service-replica04 HRService-0.0.1-SNAPSHOT.jar