package com.fadv.automation.utils;

import org.apache.commons.lang3.StringUtils;

public final class Util {

    public static String getNonAdjLocationAliasBasedOnEnvironment(String aliasIn) {
        if (StringUtils.isEmpty(aliasIn))
            return null;

        String env = System.getProperty("env");
        if(("qaa".equals(env) || "qab".equals(env)) && "RDM-STL8".equals(aliasIn)){
            return "RDM-DET1";
        }
        return aliasIn;
    }

    public static String getFileBasedOnEnvironment(String fileIn) {
        if (StringUtils.isEmpty(fileIn))
            return null;

        int endIndex = fileIn.indexOf(".json");
        String fileVal = fileIn.substring(0, endIndex);
        String file = fileVal +  "_uat.json"; //default if no environment is passed in

        String env = System.getProperty("env");

        if("qaa".equals(env) || "qab".equals(env)){
            file = fileVal +  "_qa.json";
        } else {
            if("uat".equals(env)){
                file = fileVal +  "_uat.json";
            }
        }
        return file;
    }
}
