package com.fadv.automation.api;


import com.fadv.automation.core.Environment;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.pageobjects.AmazonAdminUI;
import com.fadv.automation.rest.RestApi;
import com.fadv.automation.utils.CommonMethods;
import com.fadv.automation.utils.Util;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BackendApi extends RestApi {


    static final Logger logger = Logger.getLogger(AmazonAdminUI.class.getName());
    private String orderCandidateId;

    public void setCandidateId(String candidateId) {
        this.orderCandidateId = candidateId;
    }

    public String getCandidateId() {
        return orderCandidateId;
    }


    public BackendApi() {}
    public BackendApi(TestObject to) {
        super(to);
    }


    public String createOrder(Map<String, String> values) throws IOException {
        String file = "WAOrder.json";
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        this.setRequestContent(content);
        this.updateRequestContentByJsonPathValues(values);
        this.setEndpoint(TestObject.getProperty("data.env.url") + "/api/CreateOrder");

        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        this.setHeaders(headers);
        this.sendRequest(RestApi.Method.POST);
        return response.jsonPath().get("id").toString();
    }


    public void adjudicateSealApi(String file, String uuid, String result) throws Exception{
        uuid = testObject.processString(uuid);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        setRequestContent(content);
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/AdjudicateSeal/" + uuid + "/" + result);
        sendRequest(RestApi.Method.POST);
        logger.info("adjudicate sealed response code " + response.getStatusCode() );
    }


    public void setStatusApiEndpoint(){
        String uuidPath = Environment.getEnvironmentInviteUuid();
        String uuid = testObject.processString(uuidPath);
        Assert.assertNotNull(uuid, "UUID is null");
        Assert.assertNotEquals(uuid, "", "UUID is empty");
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/status/" + uuid);
    }

    public void updateScanResults()  {
        String uuidPath = Environment.getEnvironmentInviteUuid();
        String uuid = testObject.processString(uuidPath);
        Assert.assertNotNull(uuid, "UUID is null");
        Assert.assertNotEquals(uuid, "", "UUID is empty");
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/updateScanResult/" + uuid);
    }


    public void adminFilterByApi(String file) throws Exception{
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        setRequestContent(content);
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Search/");
    }

    public void applicantHelpWithBoothContent(String file, String status) throws Exception{
        String uuid = Environment.getEnvironmentInviteUuid();
        uuid = testObject.processString(uuid);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        setRequestContent(content);
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Help/" + uuid + "/" + status);
    }

    public Boolean searchResultsForCurrentCandidate(String lastName){
        Response response = this.getResponse();
        List<String> names = response.jsonPath().get("lastName");

        for (String name: names){
            if (name.equalsIgnoreCase(lastName)){
                return true;
            }
        }
        return false;
    }

    public void getDeviceApi(){
        String uuid = Environment.getEnvironmentInviteUuid();
        uuid = testObject.processString(uuid);
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/GetDeviceImage/device/" + uuid + ".png");
    }

    public void postResponseRetryOptional(boolean retryResponseCall) throws Exception {
        report("Getting the Endpoint for post: :" + getEndpoint());
        Response response = sendRequest(RestApi.Method.POST);
        int status = getResponse().getStatusCode();
        Set<Integer> goodStatusCodes = new HashSet<>(Arrays.asList(200, 204));
        if (retryResponseCall) {
            for (int count = 1; count < 4; count++) {
                if ((count < 3 && !goodStatusCodes.contains(status))) {
                    TimeUnit.SECONDS.sleep(5);
                    status = getResponse().getStatusCode();
                    logger.info("Retry#: " + count + " out of 3");
                    report("Response code: " + status + ", Response body: " + response.getBody().asString());
                } else {
                    count = 99;
                    report("Response code: " + status + ", Response body: " + response.getBody().asString());
                    break;
                }
            }
        } else {
            report("Response code: " + status + ", Response body: " + response.getBody().asString());
        }
    }

    public void postResponseAdminOrderInfoSet(boolean retryResponseCall) throws Exception {
        report("Getting the Endpoint for post: :" + getEndpoint());
        Response response = sendRequest(RestApi.Method.POST);
        int status = getResponse().getStatusCode();
        Set<Integer> goodStatusCodes = new HashSet<>(Arrays.asList(200, 204));
        if (retryResponseCall){
            for (int count = 1; count < 4; count++) {
                if ((count < 3 && !goodStatusCodes.contains(status))) {
                    TimeUnit.SECONDS.sleep(5);
                    status = getResponse().getStatusCode();
                    logger.info("Retry#: " + count + " out of 3");
                    report("Response code: " + status + ", Response body: " + response.getBody().asString());
                    setCandidateId(response.jsonPath().get("id"));
                } else {
                    count = 99;
                    report("Response code: " + status + ", Response body: " + response.getBody().asString());
                    setCandidateId(response.jsonPath().get("id"));
                    break;
                }
            }
        }
        else{
            report("Response code: " + status + ", Response body: " + response.getBody().asString());
            setCandidateId(response.jsonPath().get("id"));
        }

    }

    public void setAdminCandidateOrder(String fileIn) throws Exception {
        String file = Util.getFileBasedOnEnvironment(fileIn);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        setRequestContent(content);
        String endPoint = Environment.getEnvironmentBaseUrl() + "/api/candidate/";
        setEndpoint(endPoint);
        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        setHeaders(headers);
    }

    public void setAdminCandidateExistingOrder(String fileIn) throws Exception {
        String file = Util.getFileBasedOnEnvironment(fileIn);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        setRequestContent(content);
        String endPoint = Environment.getEnvironmentBaseUrl() + "/api/candidate/" + getCandidateId();
        setEndpoint(endPoint);
        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        setHeaders(headers);
    }

    public void getCandidateOrderApi(){
        String endpoint = Environment.getEnvironmentBaseUrl() + "/api/candidate/" + getCandidateId();
        setEndpoint(endpoint);
        report("Endpoint set: for candidate Admin order: " + endpoint);
    }

    public void updateJsonWithCandidateId(){
        Map<String, String> jsonValues = new HashMap<>();
        String value = testObject.processString(getCandidateId());
        jsonValues.put("id", value);
        updateRequestContentByJsonPathValues(jsonValues);
        report("Updated json Values:" + jsonValues);
    }

    public Response getPatchResponse(){
        report("Getting the Endpoint for patch:" + getEndpoint());
        Response response = sendRequest(RestApi.Method.PATCH);
        report("Patch Response: " + response.getBody().asString());
        return response;
    }

    public Response getGetResponse(){
        report("Getting the endpoint for a GET call:" + getEndpoint());
        Response response = sendRequest(RestApi.Method.GET);
        report("Response: " + response.getBody().asString());
        return response;
    }

    public void searchInvitesApi(){
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/searchInvites/");
        report("Endpoint set for Search invites: " + Environment.getEnvironmentBaseUrl() + "/api/searchInvites/");
    }

    public void updateLocationsApi() throws Exception {
        String content = CommonMethods.readTextFile("src/test/resources/templates/UpdateLocation.json");
        report("loading json from: " );
        report("content: " + content);
        setRequestContent(content);
        String candidateCollectionId = getCandidateId();
        setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/UpdateLocation/" + candidateCollectionId);
        report("Endpoint set for UpdateLocation: " + Environment.getEnvironmentBaseUrl() + "/api/UpdateLocation/" + candidateCollectionId);
    }

    public void validateUpdatedValues(Map<String, String> values){
        String responseValue;
        for (Map.Entry<String, String> map: values.entrySet())
        {
            String  currentProperty = map.getKey();
            String expectedValue = map.getValue();
            switch (currentProperty) {
                case "lastName" -> {
                    responseValue = getResponse().jsonPath().get("lastName");
                    Assert.assertEquals(responseValue, expectedValue);
                }
                case "dateOfBirth" -> {
                    responseValue = getResponse().jsonPath().get("dateOfBirth");
                    Assert.assertEquals(responseValue, expectedValue);
                }
                case "lastFourSSN" -> {
                    responseValue = getResponse().jsonPath().get("lastFourSSN");
                    Assert.assertEquals(responseValue, expectedValue);
                }
                case "firstName" -> {
                    responseValue = getResponse().jsonPath().get("firstName");
                    Assert.assertEquals(responseValue, expectedValue);
                }
                case "phoneNumber" -> {
                    responseValue = getResponse().jsonPath().get("phoneNumber");
                    Assert.assertEquals(responseValue, expectedValue);
                }
                case "status" -> {
                    responseValue = getResponse().jsonPath().get("status");
                    Assert.assertEquals(responseValue, expectedValue);
                }
                case "emailAddress" -> {
                    responseValue = getResponse().jsonPath().get("emailAddress");
                    Assert.assertEquals(responseValue, expectedValue);
                }
                default -> {
                    responseValue = "Received json property was not found. Please check the spelling or make sure the property is implemented.";
                    Assert.assertEquals(responseValue, expectedValue);
                }
            }
        }
    }

    public void setSupportToolPatchOrder(String file) throws IOException {
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        setRequestContent(content);
        String endPoint = Environment.getEnvironmentBaseUrl() + "/api/support/candidate/" + getCandidateId();
        setEndpoint(endPoint);
        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        setHeaders(headers);
        Response response=getGetResponse();
        report(response.getBody().toString());
    }

    public void updateCanidateEmailFlag(String file) throws IOException {
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        setRequestContent(content);
        String endPoint = Environment.getEnvironmentBaseUrl() + "/api/updateCandidateEmailFlag/"+getCandidateId();
        setEndpoint(endPoint);
        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        setHeaders(headers);
    }
}
