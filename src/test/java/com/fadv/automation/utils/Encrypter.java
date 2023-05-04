package com.fadv.automation.utils;

import com.fadv.automation.core.TestObject;
import com.fadv.automation.rest.RestApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Encrypter {
    protected Logger logger = Logger.getLogger(Encrypter.class.getName());

    private String valueEncrypterLocation = null;

    public Encrypter() throws IOException {
        this(TestObject.init("any"));
    }

    public Encrypter(TestObject to) {
        valueEncrypterLocation = to.getProperty("ApplicantSelfCollect.Backend.ValueEncrypter");
    }


    public String encrypt(String value) throws IOException, InterruptedException {
        String encryptedText = null;
        Process process = new ProcessBuilder(valueEncrypterLocation, value).start();
        process.waitFor();
        BufferedReader bri = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = bri.readLine()) != null) {
            logger.info("encrypted response: " + line);
            encryptedText = line;
        }
        process.destroy();
        return encryptedText;
    }

    public String encryptByWellnessAPI(String value) {
        String token = this.wellnessEncryptGetToken();
        logger.info("token: " + token);
        String encrypted = this.wellnessEncrypt(token, value);
        return encrypted;
    }

    private String wellnessEncryptGetToken() {
        String endpoint = "https://wsuat.wellness.fadv.com/WASchedulingAPI/api/External/Utilities/GetAuthToken?userid=&password=";
        Response response = (Response) RestAssured.given().contentType(ContentType.JSON).when().get(endpoint);
        return response.getBody().asString().replace("\"", "");
    }

    private String wellnessEncrypt(String token, String value) {
        String endpoint = "https://wsuat.wellness.fadv.com/WASchedulingAPI/api/External/SelfCollect/HashValue?encodeValue=" + value.trim();
        Map<String, String> headers = new HashMap<>();
        headers.put("wellnessAuth", token);
        Response response = RestAssured.given().headers(RestApi.map2Headers(headers)).contentType(ContentType.JSON).when().get(endpoint, new Object[0]);
        return response.getBody().asString().replace("\"", "");
    }

    public static void main(String[] a) throws IOException, InterruptedException {
//        Encrypter e = new Encrypter();
//        String value2Encrypt = "12345678";
//        System.out.println("Value to encrypt : " + value2Encrypt);
//
//        String value = e.encrypt(value2Encrypt);
//        System.out.println("Encrypted value for [" + value2Encrypt + "] : " + value);
//
//        String token = e.wellnessEncryptGetToken();
//        System.out.println("token = " + token);
//
//        //Thread.sleep(500);
//        //token = "TwkEvELlfmf3RE+yobTQbchuyKNf5rgLgmSBZQKfD/z6lrXEq+4DlLL8ipmeC/CL";
//
//        String encrypted = e.wellnessEncrypt(token, value2Encrypt);
//        System.out.println("Encrypted value for [" + value2Encrypt + "] : " + encrypted);

        long t = System.currentTimeMillis();
        String time = t + "";
        System.out.println("time milli = " + new String(System.currentTimeMillis()+"").substring(3));

    }
}
