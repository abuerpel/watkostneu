@echo off
set JAVA_HOME=C:\Program Files\jdk-25.0.2+10
set ANT_HOME=C:\Program Files\apache-ant-1.10.17

if "%1"=="" (
    "%ANT_HOME%\bin\ant.bat" compile
) else (
    "%ANT_HOME%\bin\ant.bat" %1
)
