package com.fadv.automation.api;

import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.Environment;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.rest.RestApi;
import com.fadv.automation.utils.Encrypter;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CreateOrderWrapper extends BaseClass {

    private String applicantUILink = null;
    private String encryptedWellnessOrderId = null;
    private JsonNode request = null;
    private Environment environment = new Environment(System.getProperty("env"));

    public CreateOrderWrapper(TestObject testObject, RestApi api) {
        this.setTestObject(testObject);
        try {
            this.request = api.getRequestJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JsonNode getRequest() {
        return request;
    }


    public String getApplicantUILink() throws IOException, InterruptedException {
        if (applicantUILink == null) {
            String encryptedValue = new Encrypter(testObject).encrypt(request.get("wellnessId").textValue());
            this.encryptedWellnessOrderId = encryptedValue;
            applicantUILink = Environment.getEnvironmentBaseUrl() + "/?location=" + environment.getEnvironmentLocationUuid();
        }
        return applicantUILink;
    }

    public String getApplicantUIRelaunchLink(){
        return Environment.getEnvironmentBaseUrl() + "/?location=" + environment.getEnvironmentLocationUuid();
    }

    public String getRequestField(String jsonPath){
        return request.get(jsonPath).textValue();
    }

    public String getEncryptedWellnessOrderId() {
        return encryptedWellnessOrderId;
    }
}
