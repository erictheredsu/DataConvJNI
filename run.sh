export LD_LIBRARY_PATH=./lib:$LD_LIBRARY_PATH
echo $LD_LIBRARY_PATH
echo "put the libDataConv.so to ./lib folder"
echo "put the DataConv.jar and commons-codec-1.15.jar to . folder"
java -Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=0.0.0.0:5005 -jar DataConvJNI.jar

