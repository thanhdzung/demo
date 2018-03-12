@REM http://registry1:9001
@echo off
TITLE eureka-server-registry1
java -jar -Dspring.profiles.active=registry1 EurekaServer-0.0.1-SNAPSHOT.jar