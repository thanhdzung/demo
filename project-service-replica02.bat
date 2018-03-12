@echo off
TITLE project-service-replica02: http://localhost:6212
java -jar -Dspring.profiles.active=project-service-replica02 ProjectService-0.0.1-SNAPSHOT.jar