@echo off
TITLE hr-service-replica03: http://localhost:6203
java -jar -Dspring.profiles.active=hr-service-replica03 HRService-0.0.1-SNAPSHOT.jar