package com.sap.businessone.dboperation;

import org.apache.commons.codec.binary.Base64;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class Main {

    public static void main( String[] args )
    {
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        String pid = jvmName.split("@")[0];
        System.out.println("current process Id=" + pid);

        //wait for input to continue
        Scanner input = new Scanner(System.in);
        String val= null;
        do{
            System.out.println("please input ok to continue");
            val = input.next();
            System.out.println("you input:" + val);
        }while(!val.equals("ok"));


        System.out.println( "before load library" );
        loadLibraries();
        System.out.println( "after load library" );

        boolean istrial = isTrialLicense();
        if(istrial){
            System.out.println("current is trial License");
        }
        else {
            System.out.println("current is not trial License");
        }
    }

    private static final int TRIAL_PERIOD = 31;
    public static boolean isTrialLicense(){
        String installNo     = "SAP-INTERN";
        String compRawData   = "UXviyZVX1AIPhV2rV/gubIg3Vg8AFrF3KkGP8Z9ITt6SW9KzEjXBsA==";
        String commonRawData = "UXviyZVX1AIPhV2rV/gubAUFyuQsjGwV";
        boolean isOD = true;
        try
        {
            DataConvJNI caller = new DataConvJNI();
            return caller.isInTrail(installNo,isOD, Base64.decodeBase64(compRawData),
                    Base64.decodeBase64(commonRawData),
                    TRIAL_PERIOD, System.currentTimeMillis());
        }
        catch(Exception e)
        {
            throw new RuntimeException("Failed on checking trial license",e);
        }
    }

    public static void loadLibraries() {
        try {

            String os = System.getProperty("os.name");
            //In Windows Env, there is conflict between license and DIAPI in path env varibale
            if(os.toLowerCase().startsWith("win")){
                String libFolder = "D:\\workspace\\tempwork\\DataConvJNI\\lib\\";

                if(!libFolder.isEmpty())
                {
                    System.load(libFolder+"\\" + "DataConv.dll");
                }
                else
                {
                    System.loadLibrary("DataConv.dll");
                }

            }
            else
            {
                System.out.println("Linux before load B1_LicenseEngine");
                System.loadLibrary("/usr/sap/DataConv");
                System.out.println("Linux after load B1_LicenseEngine");
            }


        } catch (Exception e) {
            throw new RuntimeException("Failed to load required library", e);
        }
    }
}
