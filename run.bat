@ECHO OFF
CHCP 1252 >NUL
CD /D "%~dp0"

SET JAVA_HOME=C:\dev19\java\jdk\jdk-10

SET CLASSPATH=bin;..\JFox\bin;..\~UtilServeurs\lib\*;..\~libraries\jasperreports-6.12\*

START  %JAVA_HOME%\bin\javaw.exe  projet.MainProjet
