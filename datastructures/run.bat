@echo off
for %%I in (.) do set project_name=%%~nxI

call mvn clean package

echo.
call java -jar target\%project_name%-1.0-SNAPSHOT.jar
