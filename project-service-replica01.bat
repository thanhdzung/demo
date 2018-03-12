@echo off
TITLE project-service-replica01: http://localhost:6211
java -jar -Dspring.profiles.active=project-service-replica01 ProjectService-0.0.1-SNAPSHOT.jar