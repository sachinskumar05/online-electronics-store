@ECHO OFF
ECHO Please press enter to start mongo DB server.
echo "%CD%/../data"
PAUSE
start mongod.exe --dbpath %CD%/../data
