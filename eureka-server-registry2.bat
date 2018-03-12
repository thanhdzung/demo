@REM http://registry2:9002
@echo off
TITLE eureka-server-registry2
java -jar -Dspring.profiles.active=registry2 EurekaServer-0.0.1-SNAPSHOT.jar