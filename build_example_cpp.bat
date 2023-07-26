REM firstly you need install mingw and get gcc available.
cd .\src\main\java
gcc -Wl,--add-stdcall-alias -shared -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" DataConvJNI.cpp -o DataConv.dll