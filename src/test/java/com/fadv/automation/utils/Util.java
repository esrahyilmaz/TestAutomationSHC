package com.fadv.automation.utils;

import org.apache.commons.lang3.StringUtils;

public final class Util {

    private static String env = System.getProperty("env");

    public static String getLocationAliasBasedOnEnvironment(String alias) {
        String qaaLocationAlias = "";
        String uatLocationAlias = "";
        String prdLocationAlias = "";

        if ("CLT4".equals(alias)||"TEST".equals(alias)) { //PreEmployment
            qaaLocationAlias = "CLT4";
            uatLocationAlias = "CLT4";
            prdLocationAlias = "TEST";
        } else if ("RDM-CLT4".equals(alias) || "RDM-FATST".equals(alias)) { //Random
            qaaLocationAlias = "RDM-CLT4";
            uatLocationAlias = "RDM-CLT4";
            prdLocationAlias = "RDM-FATST";
        } else if ("RDM-DET1".equals(alias) || "RDM-STL8".equals(alias) || "RDM-FATTT".equals(alias)) { //Validation
            qaaLocationAlias = "RDM-DET1";
            uatLocationAlias = "RDM-STL8";
            prdLocationAlias = "RDM-FATTT";
        }else if ("POSTEMP-FATST".equals(alias)) { //RandomAir
            qaaLocationAlias = ""; //no location for qaa
            uatLocationAlias = "POSTEMP-FATST";
            prdLocationAlias = "POSTEMP-FATST";
        }
        else if ("POSTEMP-FATTT".equals(alias)) { //RandomAirValidation
            qaaLocationAlias = ""; //no location for qaa
            uatLocationAlias = "POSTEMP-FATTT";
            prdLocationAlias = "POSTEMP-FATTT";
        }
        else if ("POSTEMP-TST1".equals(alias)) { //RandomUSSC
            qaaLocationAlias = ""; //no location for qaa
            uatLocationAlias = "POSTEMP-TST1";
            prdLocationAlias = "POSTEMP-TST1";
        }
        else if ("POSTEMP-TST2".equals(alias)) { //RandomUSSC validation
            qaaLocationAlias = ""; //no location for qaa
            uatLocationAlias = "POSTEMP-TST2";
            prdLocationAlias = "POSTEMP-TST2";
        }

        String env = System.getProperty("env");

        if("qaa".equals(env) || "qab".equals(env)){
            return qaaLocationAlias;
        } else if ("uat".equals(env)){
            return uatLocationAlias;
        } else if ("prd".equals(env) || "prdrnd".equals(env)||"prdrndval".equals(env)|| "prdair".equals(env)|| "prdairval".equals(env)||"prduss".equals(env)||"prdussval".equals(env)) {
            return prdLocationAlias;
        }

        return uatLocationAlias; //default if no env is passed in
    }

    public static String getFileBasedOnEnvironment(String fileIn) {
        if (StringUtils.isEmpty(fileIn))
            return null;

        if (fileIn.toUpperCase().indexOf("INVALID") > -1 || fileIn.indexOf("emailResult") > -1) {
            return fileIn;
        }

        int endIndex = fileIn.indexOf(".json");
        String fileVal = fileIn.substring(0, endIndex);
        String file = fileVal +  "_uat.json"; //default if no environment is passed in

        if("qaa".equals(env) || "qab".equals(env)){
            file = fileVal +  "_qa.json";
        } else if ("uat".equals(env)){
            file = fileVal +  "_uat.json";
        } else if ("prd".equals(env) || "prdrnd".equals(env)||"prdrndval".equals(env)|| "prdair".equals(env)|| "prdairval".equals(env)||"prduss".equals(env)||"prdussval".equals(env)){
            file = fileVal + "_prd.json";
        }

        return file;
    }
}
