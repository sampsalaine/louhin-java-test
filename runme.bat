@echo off
setlocal EnableDelayedExpansion
set CLASSPATH=target;
for %%f in (target\*.jar) do set CLASSPATH=!CLASSPATH!;%%f
java.exe -classpath %CLASSPATH% -Xmx1000m com.louhin.test.RunTest
endlocal
pause
