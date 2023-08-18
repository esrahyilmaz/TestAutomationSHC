package com.fadv.automation.utils;

public class Utility {
    private static String env = System.getProperty("env");

    public static String getConfigPropsFileBasedOnEnvironment() {
        String file = "config_uat.properties"; //default if no environment is passed in

        if("qaa".equals(env) || "qab".equals(env)){
            file = "config_qa.properties";
        } else if ("uat".equals(env)){
            file = "config_uat.properties";
        } else if ("prd".equals(env) || "prdrnd".equals(env)||"prdrndval".equals(env)|| "prdair".equals(env)|| "prdairval".equals(env)||"prduss".equals(env)||"prdussval".equals(env)){
            file = "config_prd.properties";
        }

        return file;
    }
}
