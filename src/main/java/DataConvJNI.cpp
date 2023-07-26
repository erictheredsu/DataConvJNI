#include "DataConvJNI.h"
#include <jni.h>
#include <stdio.h>
#include <string.h>

JNIEXPORT jint JNICALL Java_com_sap_businessone_dboperation_DataConvJNI_getRemainDays
  (JNIEnv *, jclass, jbyteArray, jint, jlong)
  {
    printf("Call getRemainDays\n");
    return 0;
  }

JNIEXPORT jbyteArray JNICALL Java_com_sap_businessone_dboperation_DataConvJNI_getCreateDateStr
  (JNIEnv * env, jclass, jlong)
{
    printf("Call getCreateDateStr\n");
    // int size = 256;
    // jbyte* buf = new jbyte[size];
    // memset (buf, 0, size);
    // jbyteArray ret = env->NewByteArray(size);
    // env->SetByteArrayRegion (ret, 0, size, buf);
    // delete[] buf;
    return nullptr;
}

JNIEXPORT jboolean JNICALL Java_com_sap_businessone_dboperation_DataConvJNI_isInTrail
  (JNIEnv *, jclass, jstring, jboolean, jbyteArray, jbyteArray, jint, jlong)
{
    printf("Call isInTrail\n");
    return true;
}

JNIEXPORT jstring JNICALL Java_com_sap_businessone_dboperation_DataConvJNI_decrypt
  (JNIEnv * env, jclass, jbyteArray)
{
    printf("Call decrypt\n");
    char msg[60] = "Hello ";
    jstring result;
    result = env->NewStringUTF(msg);
    return result;     
}