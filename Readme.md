to run the project
1, modify the DataConvJNI.java to change interface (don't need to change)
2, run gen_header_file.bat to create  C header file
3, add a cpp file and implement the function
4, run build_example_cpp.bat to build the dll (need install GCC first, mingw in windows. visual studio can't compile, java include folder always not effect)
5, put dll/so to  ./lib
6, in Intellij IDEA, run debug directly

for linux: 
7,build jar in Intellij IDEA
8,copy DataConv.jar and commons-codec-1.15.jar, libDataConv.so , run.sh to linux, put libDataConv.so to ./lib
9,run run.sh
