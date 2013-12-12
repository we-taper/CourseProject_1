@echo off
SETLOCAL
echo.
echo.
cd "%~p1"
echo.%var%
java "%~n1" %var%
Endlocal
pause >nul