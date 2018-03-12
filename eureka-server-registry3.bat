@REM http://registry3:9003
@echo off
TITLE eureka-server-registry3
java -jar -Dspring.profiles.active=registry3 EurekaServer-0.0.1-SNAPSHOT.jar