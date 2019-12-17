@echo off  
echo Setting JAVA_HOME  
setx -m JAVA_HOME "C:\Program Files\Java\jdk1.8.0_212"
echo JAVA_HOME: %JAVA_HOME% 
echo setting PATH
setx -m PATH "%Path%;%JAVA_HOME%\bin"
echo PATH: %PATH%  
echo Display java version  
java -version  
pause