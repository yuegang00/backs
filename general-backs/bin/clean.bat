@echo off
rem /**
rem  * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
rem  *
rem  * Author: ThinkGem@163.com
rem  */
echo.
echo [ÐÅÏ¢] ÇåÀíÉú³ÉÂ·¾¶¡£
echo.

%~d0
cd %~dp0

cd ..
call mvn clean

pause