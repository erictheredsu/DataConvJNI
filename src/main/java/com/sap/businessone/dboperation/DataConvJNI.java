package com.sap.businessone.dboperation;

public class DataConvJNI {


    public static native int getRemainDays(byte[] rawData, int trialPeriod, long currentDate);

    public static native byte[] getCreateDateStr(long currentDate);
    public static native boolean isInTrail(String installNo, boolean isOD, byte[] compRawData,byte[] commonRawData, int trialPeriod,long currentDate);

    public static native String decrypt(byte[] RowData);

}
