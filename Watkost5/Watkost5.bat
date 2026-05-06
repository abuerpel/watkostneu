@echo off
rem Watkost5 Launcher.
rem Doppelklick startet das Programm. Der Klassenpfad nutzt Wildcards
rem und nimmt alle JARs in bin/ automatisch auf.
rem
rem Bei Problemen: "javaw" durch "java" ersetzen und aus cmd.exe heraus
rem starten, dann sind Stack-Traces sichtbar.
rem Falls das JDK nicht im PATH ist, vollen Pfad zu javaw.exe einsetzen,
rem z.B.  "C:\Program Files\jdk-25.0.2+10\bin\javaw.exe" statt "javaw"

cd /d "%~dp0"
start "" javaw -cp "bin\*;classes" watkost
