@echo off
TITLE project-service-replica03: http://localhost:6213
java -jar -Dspring.profiles.active=project-service-replica03 ProjectService-0.0.1-SNAPSHOT.jar