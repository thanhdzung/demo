@echo off
TITLE hr-service-replica05: http://localhost:6205
java -jar -Dspring.profiles.active=hr-service-replica05 HRService-0.0.1-SNAPSHOT.jar