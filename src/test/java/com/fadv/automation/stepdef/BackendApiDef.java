package com.fadv.automation.stepdef;

import com.fadv.automation.Constants;
import com.fadv.automation.api.BackendApi;
import com.fadv.automation.api.CreateOrderWrapper;
import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.Environment;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.rest.RestApi;
import com.fadv.automation.utils.CommonMethods;
import com.fadv.automation.utils.Encrypter;
import com.fadv.automation.utils.Util;
import com.fadv.automation.utils.UtilTextProcessor;
import com.fadv.automation.xchange.Xchange;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class BackendApiDef extends BaseClass {

    private BackendApi api = null;

    @Before
    public void before(Scenario scenario) throws IOException {
        testObject = TestObject.createWith(scenario);

    }

    @After
    public void after(Scenario scenario) {
        if (testObject != null) {
            testObject.testComplete();
        }
    }

    @Given("a request json {string} for LookupOrder api")
    public void a_request_json_for_LookupOrder_api(String file) throws IOException {
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");

        if (api == null) {
            api = new BackendApi();
        }

        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint( Environment.getEnvironmentBaseUrl() + "/api/LookupOrder/");
    }

    @Given("a request json {string} for LookupInvite api")
    public void a_request_json_for_LookupInvite_api(String fileIn) throws IOException {
        Assert.assertNotNull(fileIn, "FileName is null");
        Assert.assertNotEquals(fileIn, "", "FileName is empty");

        if (api == null) {
            api = new BackendApi();
        }
        String file = Util.getFileBasedOnEnvironment(fileIn);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint( Environment.getEnvironmentBaseUrl() + "/api/lookupInvite/");
    }


    @Given("update the json request")
    public void updateTheJsonRequest(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> jsonValues = new HashMap<>();
        List<List<String>> values = dataTable.asLists();
        for (int i = 1; i < values.size(); i++) {
            String field = values.get(i).get(0);
            String value = values.get(i).get(1);
            value = UtilTextProcessor.processText(value);
            value = testObject.processString(value);
            if (field != null || !field.isEmpty()) {
                jsonValues.put(field, value);
            }
        }
        // TestObject.setSharedData(jsonValues); // save to sharedData
        api.updateRequestContentByJsonPathValues(jsonValues);
        //report("updated content: " + api.getRequestContent());
    }

    @When("a POST call is sent to the api")
    public void a_POST_call_is_sent_to_the_api() throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        api.postResponseRetryOptional(false);
    }


    @Then("a response should return with status {string}")
    public void a_response_should_return_with_status(String httpStatus) {
        String responseStatus = api.getResponse().getStatusCode() + "";
        Assert.assertEquals(responseStatus, httpStatus, "HttpStatus was not equal to " + httpStatus);
        report("responseStatus = " + responseStatus + ", expected httpStatus = " + httpStatus);
    }

    @Then("validate the LookupOrder api response")
    public void validate_the_LookupOrder_api_response() {
        Response response = this.api.getResponse();

        Assert.assertNotNull(response.jsonPath().get("id"), "id");
        Assert.assertNotNull(response.jsonPath().get("location"), "location");
        Assert.assertNotNull(response.jsonPath().get("requestStation"), "requestStation");
    }

    @Then("validate the LookupInvite api response")
    public void validate_the_LookupInvite_api_response() {
        Response response = this.api.getResponse();

        Assert.assertNotNull(response.jsonPath().get("inviteId"), "inviteId");
        Assert.assertNotNull(response.jsonPath().get("status"), "status");
        Assert.assertNotNull(response.jsonPath().get("step"), "step");
        Assert.assertNotNull(response.jsonPath().get("phoneNumber"), "phoneNumber");
        Assert.assertNotNull(response.jsonPath().get("address.line1"), "address.line1");
        Assert.assertNotNull(response.jsonPath().get("address.city"), "address.city");
        Assert.assertNotNull(response.jsonPath().get("address.state"), "address.state");
        Assert.assertNotNull(response.jsonPath().get("address.zip"), "address.zip");
    }

    @Given("a request for getActiveTestsForLocation api for location {string}")
    public void a_request_for_getActiveTestsForLocation_api_for_location(String uuid) {
        Assert.assertNotNull(uuid, "UUID is null");
        Assert.assertNotEquals(uuid, "", "UUID is empty");
        if (api == null) {
            api = new BackendApi(testObject);
        }
        uuid = testObject.processString(uuid);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/getActiveTestsForLocation/" + uuid);
    }

    @When("a GET call is sent to the api")
    public void a_GET_call_is_sent_to_the_api() {
       api.getGetResponse();
    }

    @Then("validate the Status api response")
    public void validate_the_Status_api_response() {
        Response response = this.api.getResponse();
        Assert.assertNotNull(response.jsonPath().get("status"), "status");
        Assert.assertNotNull(response.jsonPath().get("step"), "step");
    }

    @Then("validate the Status api response with status {string}")
    public void validateTheStatusApiResponseWithStatus(String expectedStatus) {
        Response response = this.api.getResponse();
        String status = response.jsonPath().get("step").toString();
        Assert.assertEquals(status, expectedStatus, "Step does not equal to the expected");
    }

    @Then("validate the json api response")
    public void validateTheJsonApiResponse(io.cucumber.datatable.DataTable dataTable) {
        Response response = this.api.getResponse();
        List<List<String>> values = dataTable.asLists();
        for (int i = 1; i < values.size(); i++) {
            String field = values.get(i).get(0);
            String expectedValue = values.get(i).get(1);

            if (field != null || !field.isEmpty()) {
                String responseValue = response.jsonPath().get(field).toString();
                Assert.assertEquals(responseValue, expectedValue, "response value does not equal to the expected");
                report("response value for json path [" + field + "] = " + responseValue + ", expected value = " + expectedValue);
            }
        }
    }


    @Then("validate the SubmitImage api response")
    public void validate_the_SubmitImage_api_response() {
        Response response = this.api.getResponse();
        Assert.assertNotNull(response.jsonPath().get("id"), "id");
        Assert.assertNotNull(response.jsonPath().get("drugTestImage"), "drugTestImage");
    }


    @Given("a request for GetActiveTestsForLocation api with location {string}")
    public void a_request_for_GetActiveTestsForLocation_api_with_location(String location) {
        if (api == null) {
            api = new BackendApi();
        }
        Assert.assertNotNull(location, "LocationID is null");
        Assert.assertEquals(location, "", "LocationID is empty");

        api.setEndpoint("/api/getActiveTestsForLocation/" + location);
    }

    @Then("validate the GetActiveTestsForLocation api response")
    public void validate_the_GetActiveTestsForLocation_api_response() {
        Response response = this.api.getResponse();
        Assert.assertNotNull(response.jsonPath().get("id"), "id");
    }

    @Given("a request for Location api")
    public void a_request_for_Location_api() {
        if (api == null) {
            api = new BackendApi();
        }
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/location");
    }

    @Then("validate the Location api response")
    public void validate_the_Location_api_response() {
        Response response = this.api.getResponse();

        List<String> ids = response.jsonPath().get("id");
        List<String> names = response.jsonPath().get("name");
        for (int i = 0; i < ids.size(); i++) {
            report("checking location :" + ids.get(i) + ", name :" + names.get(i));
            Assert.assertNotNull(ids.get(i));
            Assert.assertNotNull(names.get(i));
        }
    }

    @Given("a request json {string} for Admin Help api with invite uuid {string} for status {string}")
    public void a_request_json_for_Admin_Help_api_with_invite_uuid_for_status(String file, String uuid, String helpStatus) throws IOException {
        if (api == null) {
            api = new BackendApi();
        }
        Assert.assertNotNull(file, "File is null");
        Assert.assertNotEquals(file, "", "File is empty");
        Assert.assertNotNull(uuid, "Invite UUID is null");
        Assert.assertNotEquals(uuid, "", "Invite UUID is empty");
        Assert.assertNotNull(helpStatus, "Help Status is null");
        Assert.assertNotEquals(helpStatus, "", "Help Status is empty");


        uuid = testObject.processString(uuid);

        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Help/" + uuid + "/" + helpStatus);
    }

    @Given("a request json {string} for Adjudicate api with invite uuid {string} for result {string}")
    public void a_request_json_for_Adjudicate_api_with_invite_uuid_for_result(String file, String uuid, String result) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        Assert.assertNotNull(file, "File is null");
        Assert.assertNotEquals(file, "", "File is empty");
        Assert.assertNotNull(uuid, "Invite UUID is null");
        Assert.assertNotEquals(uuid, "", "Invite UUID is empty");
        Assert.assertNotNull(result, "Drug result is null");
        Assert.assertNotEquals(result, "", "Drug result is empty");


        uuid = testObject.processString(uuid);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Adjudicate/" + uuid + "/" + result);
    }


    @Given("a request json {string} for CreateOrder api")
    public void aRequestJsonForCreateOrderApi(String fileIn) throws IOException {

        Assert.assertNotNull(fileIn, "FileName is null");
        Assert.assertNotEquals(fileIn, "", "FileName is empty");

        if (api == null) {
            api = new BackendApi();
        }

        String file = Util.getFileBasedOnEnvironment(fileIn);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        String endPoint = Environment.getEnvironmentBaseUrl() + "/api/CreateOrder/";
        api.setEndpoint(endPoint);

        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        api.setHeaders(headers);
    }


    @Then("validate the CreateOrder api response")
    public void validateTheCreateOrderApiResponse() throws IOException, InterruptedException {
        Response response = this.api.getResponse();
        Assert.assertNotNull(response.jsonPath().get("id"), "id");

        String id = response.jsonPath().get("id").toString();
        testObject.setRuntimeData("invite-uuid", id);

        if (id != null) {
            CreateOrderWrapper order = new CreateOrderWrapper(testObject, api);
            String url = order.getApplicantUILink();
            String lastName = order.getRequestField("lastName");
            String firstName = order.getRequestField("firstName");

            testObject.setRuntimeData("invite-name", firstName + " " + lastName);

            String encryptedOrderId = order.getEncryptedWellnessOrderId();
            testObject.setRuntimeData("invite-encrypted-wellness-order-id", encryptedOrderId);

            String dob = order.getRequestField("dateOfBirth");
            report("Applicant [" + lastName + "] dob [" + dob + "] URL: " + url);
        }
    }

    @Given("a request to generate Candidate Invite data")
    public void a_request_to_generate_Candidate_Invite_data() throws IOException {
        //String file = "WAOrder.json";
        if (api == null) {
            api = new BackendApi();
            api.setTestObject(testObject);
        }

        // create a test-in-progress candidate
        Map<String, String> values = new HashMap<>();
        values.put("firstName", "Invite");
        values.put("lastName", "Automation");
        values.put("dateOfBirth", "01/01/2000");
        values.put("address.line1", "1000 main street");
        values.put("address.city", "Duluth");
        values.put("address.state", "GA");
        values.put("address.zip", "30097");
        values.put("phoneNumber", "404-229-1234");
        values.put("ssn", "3451");
        values.put("expires", "01/01/2022");

        String wellnessId = (System.currentTimeMillis() + "").substring(4); // get system time and shift 3 digits
        values.put("wellnessId", wellnessId);

        api.createOrder(values);
        Response response = api.getResponse();

        System.out.println("response code = " + response.getStatusCode());
        System.out.println("response body = " + response.asString());

        String id = response.jsonPath().get("id").toString();
        testObject.setRuntimeData("runtime.invite.uuid", id);

        try {
            String encryptedWellnessId = new Encrypter(testObject).encrypt(wellnessId);
            values.put("wellnessIdEncrypted", encryptedWellnessId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        values.put("id", id);
        TestObject.setSharedData("Applicant", values);
    }

    @Given("a request for CreateOrder and POST to the api")
    public void a_request_for_CreateOrder_and_POST_to_the_api(io.cucumber.datatable.DataTable dataTable) throws Exception {
        this.aRequestJsonForCreateOrderApi("WAOrder.json");
        this.updateTheJsonRequest(dataTable);
        this.a_POST_call_is_sent_to_the_api();
        this.a_response_should_return_with_status("200");
        this.validateTheCreateOrderApiResponse();

        testObject.setRuntimeData(Constants.BACKEND_API, api);
    }
    @Given("a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Orders")
    public void a_request_for_CreateOrder_and_POST_to_the_api_for_reasonForTest_NonpreemploymentOrders(io.cucumber.datatable.DataTable dataTable) throws Exception {
        this.aRequestJsonForCreateOrderApi("WAOrderAlias.json");
        this.updateTheJsonRequest(dataTable);
        this.a_POST_call_is_sent_to_the_api();
        this.a_response_should_return_with_status("200");
        this.validateTheCreateOrderApiResponse();

        testObject.setRuntimeData(Constants.BACKEND_API, api);
    }

    @Given("a request for CreateOrder and POST to the api for reasonForTest Non-Preemployment Non-Adjudicate  Orders")
    public void a_request_for_CreateOrder_and_POST_to_the_api_for_reasonForTest_NonpreemploymentNonadjudicateOrders(io.cucumber.datatable.DataTable dataTable) throws Exception {
        this.aRequestJsonForCreateOrderApi("WAOrderRndNonAdj.json");
        this.updateTheJsonRequest(dataTable);
        this.a_POST_call_is_sent_to_the_api();
        this.a_response_should_return_with_status("200");
        this.validateTheCreateOrderApiResponse();

        testObject.setRuntimeData(Constants.BACKEND_API, api);
    }
    @And("a request json {string} for Adjudicate Sealed api with invite uuid {string} for result {string}")
    public void aRequestJsonForAdjudicateSealedApiWithInviteUuidForResult(String file, String uuid, String result) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        Assert.assertNotNull(file, "File is null");
        Assert.assertNotEquals(file, "", "File is empty");
        Assert.assertNotNull(uuid, "Invite UUID is null");
        Assert.assertNotEquals(uuid, "", "Invite UUID is empty");
        Assert.assertNotNull(result, "Drug result is null");
        Assert.assertNotEquals(result, "", "Drug result is empty");

        api.adjudicateSealApi(file, uuid, result);
    }

    @Then("create a new case using Xchange 1Step")
    public void createANewCaseUsingXchange1Step(io.cucumber.datatable.DataTable dataTable) throws IOException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        String file = rows.get(0).get("file");

        String xmlContent = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading xml from: " + file);
        new Xchange(testObject).content(xmlContent).sendAs(Constants.XCHANGE_1STEP);
    }


    @Then("I verify the order was created via One Step Xchange")
    public void iVerifyTheOrderWasCreatedViaOneStepXchange() {
        report("Order ID created " + testObject.getRuntimeData(Constants.CID));
        Assert.assertNotNull(testObject.getRuntimeData(Constants.CID), "OrderId was null.");
    }

    @Given("a request for Status api with invite uuid")
    public void aRequestForStatusApiWithInviteUuid() {
        if (api == null) {
            api = new BackendApi();
        }
       api.setStatusApiEndpoint();
    }

    @Given("a request json {string} for Status api with invite uuid")
    public void aARequestJsonForStatusApiWithInviteUuid(String file) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        String uuid = Environment.getEnvironmentInviteUuid();
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        Assert.assertNotNull(uuid, "Invite uuid is null");
        Assert.assertNotEquals(uuid, "", "Invite uuid is empty");

        testObject.processString(uuid);

        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        Response response = this.api.getResponse();
        String id = response.jsonPath().get("id").toString();
        report("id= "+id);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/status/"+id);
    }

    @Given("a request json {string} for SubmitImage api with runtime invite uuid")
    public void aRequestJsonForSubmitImageApiWithRuntimeInviteUuid(String file) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        String uuid = "data.runtime.invite-uuid";
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        Assert.assertNotNull(uuid, "Invite uuid is null");
        Assert.assertNotEquals(uuid, "", "Invite uuid is empty");

        uuid = testObject.processString(uuid);


        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/SubmitImage/" + uuid);
    }

    @Given("a request for Help api with invite uuid for status {string}")
    public void aRequestForHelpApiWithInviteUuidForStatus(String status) {
        if (api == null) {
            api = new BackendApi();
        }
        String uuid = "data.runtime.invite-uuid";
        Assert.assertNotNull(status, "Status is null");
        Assert.assertNotEquals(status, "", "Status is empty");
        Assert.assertNotNull(uuid, "Invite uuid is null");
        Assert.assertNotEquals(uuid, "", "Invite uuid is empty");

        uuid=testObject.processString(uuid);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Help/"+uuid+"/"+ status);
    }
    
    @Given("a request json {string} for UpdatePhoneNumber api with invite uuid")
    public void aRequestJsonForUpdatePhoneNumberApiWithInviteUuid(String file) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }

        String uuid = Environment.getEnvironmentInviteUuid();
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        Assert.assertNotNull(uuid, "Invite uuid is null");
        Assert.assertNotEquals(uuid, "", "Invite uuid is empty");

         testObject.processString(uuid);

        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        Response response = this.api.getResponse();
        String id = response.jsonPath().get("id").toString();
        report("id= "+id);

        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/updateContactInformation/"+id);
    }

    @Given("a request for getActiveTestsForLocation api for default location")
    public void aRequestForGetActiveTestsForLocationApiForDefaultLocation() {
        if (api == null) {
            api = new BackendApi(testObject);
        }
        String uuid = Environment.getEnvironmentLocationUuid();
        Assert.assertNotNull(uuid, "UUID is null");
        Assert.assertNotEquals(uuid, "", "UUID is empty");

        uuid = testObject.processString(uuid);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/getActiveTestsForLocation/" + uuid);
    }

    @Given("a request json {string} for Admin Help api with default invite uuid for status {string}")
    public void aRequestJsonForAdminHelpApiWithDefaultInviteUuidForStatus(String file, String helpStatus) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        String uuid = Environment.getEnvironmentInviteUuid();
        Assert.assertNotNull(file, "File is null");
        Assert.assertNotEquals(file, "", "File is empty");
        Assert.assertNotNull(uuid, "Invite UUID is null");
        Assert.assertNotEquals(uuid, "", "Invite UUID is empty");
        Assert.assertNotNull(helpStatus, "Help Status is null");
        Assert.assertNotEquals(helpStatus, "", "Help Status is empty");

         testObject.processString(uuid);

        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        Response response = this.api.getResponse();
        String id = response.jsonPath().get("id").toString();
        report("id= "+id);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Help/"+id+"/" + helpStatus);
    }

    @And("a request json {string} for SubmitImage api with invite uuid")
    public void aRequestJsonForSubmitImageApiWithInviteUuid(String file) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        String uuid = Environment.getEnvironmentInviteUuid();
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        Assert.assertNotNull(uuid, "Invite uuid is null");
        Assert.assertNotEquals(uuid, "", "Invite uuid is empty");
        uuid = testObject.processString(uuid);
        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/SubmitImage/" + uuid);
    }

    @When("a request json {string} for Filter By Search")
    public void aRequestJsonForFilterBySearch(String file) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        api.adminFilterByApi(file);
    }

    @When("a request for Applicant UI help api with invite uuid with content file {string} and status {string}")
    public void aRequestForApplicantUIHelpApiWithInviteUuidWithContentFileAndStatus(String file, String status) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        api.applicantHelpWithBoothContent(file, status);
    }

    @And("a request for getDeviceImage api with runtime invite uuid")
    public void aRequestForGetDeviceImageApiWithRuntimeInviteUuid() {
        if (api == null) {
            api = new BackendApi();
        }
        api.getDeviceApi();
    }

    @When("a Post call is sent to the api with retries")
    public void aPostCallIsSentToTheApiWithRetries() throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        api.postResponseRetryOptional(true);
    }

    @Given("a request json {string} for Admin CreateOrder api")
    public void aRequestJsonForAdminCreateOrderApi(String file) throws Exception {
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        if (api == null) {
            api = new BackendApi();
        }
        api.setAdminCandidateOrder(file);
    }

    @And("a request to retrieve an existing candidate for the CreateOrder api")
    public void aRequestToRetrieveAnExistingCandidateForTheCreateOrderApi() {
        if (api == null) {
            api = new BackendApi();
        }
        api.getCandidateOrderApi();
    }

    @And("a PATCH call is sent to the api")
    public void aPATCHCallIsSentToTheApi() {
       api.getPatchResponse();
    }

    @And("update the json with the current candidate id")
    public void updateTheJsonWithTheCurrentCandidateId() {
        api.updateJsonWithCandidateId();
    }

    @Given("a request to retrieve existing Candidates via Admin SearchInvites api")
    public void aRequestToRetrieveExistingCandidatesViaAdminSearchInvitesApi() {
        if (api == null) {
            api = new BackendApi();
            api.searchInvitesApi();
        }
    }

    @And("a request json {string} for Admin CreateOrder Patch api")
    public void aRequestJsonForAdminCreateOrderPatchApi(String file) throws Exception {
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        if (api == null) {
            api = new BackendApi();
        }
        api.setAdminCandidateExistingOrder(file);
    }

    @Then("I verify the Create Order Candidate information is updated")
    public void iVerifyTheCreateOrderCandidateInformationIsUpdated(DataTable dataTable) {
        HashMap<String, String> map = new HashMap<>();
        List<List<String>> values = dataTable.asLists();
        for (int i = 1; i < values.size(); i++) {
            String field = values.get(i).get(0);
            String value = values.get(i).get(1);
            map.put(field, value);
        }
        api.validateUpdatedValues(map);
    }

    @And("a Post call with Admin UI order information is sent to the api")
    public void aPostCallWithAdminUIOrderInformationIsSentToTheApi() throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        api.postResponseAdminOrderInfoSet(false);
    }

    @And("a request json {string} to UpdateScanResults")
    public void aRequestJsonToUpdateScanResults(String arg0) {
        if (api == null) {
            api = new BackendApi();
        }
        api.updateScanResults();
    }

    @When("a request to update to location {string} for existing Order via Admin UI")
    public void aRequestToUpdateToLocationForExistingOrderViaAdminUI(String locationId) throws Exception {
        if (api == null) {
            api = new BackendApi();
        }
        api.updateLocationsApi();
    }

    @And("a request json {string} for SubmitImage api for Admin UI order")
    public void aRequestJsonForSubmitImageApiForAdminUiOrder(String file) throws IOException {

            if (api == null) {
                api = new BackendApi();
            }

            Assert.assertNotNull(file, "FileName is null");
            Assert.assertNotEquals(file, "", "FileName is empty");
            String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
            report("loading json from: " + file);
            report("content: " + content);
            api.setRequestContent(content);
            api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/SubmitImage/"+ api.getCandidateId());
            //report("uuid"+uuid);
            Map<String, String> headers = new HashMap<>();
            headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
            api.setHeaders(headers);
    }

    @When("a request json {string} for Confirmation-Verification api")
    public void aRequestJsonForConfirmationVerificationApi(String file) throws IOException {
        if (api == null) {
            api = new BackendApi();
        }
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");

        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Adjudicate/" + api.getCandidateId()+"/confirmation");
        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        api.setHeaders(headers);
    }
    @When("a request json {string} for Negative-Verification api")
    public void aRequestJsonForNegativeVerificationApi(String file) throws IOException {
        if (api == null) {
            api = new BackendApi();
        }
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");

        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/Adjudicate/" + api.getCandidateId()+"/negative");
        Map<String, String> headers = new HashMap<>();
        headers.put(TestObject.getProperty("authorization.header.key"), TestObject.getProperty("authorization.header.value"));
        api.setHeaders(headers);
    }

    @And("I validate the candidate by last name {string} exists in the search results")
    public void iValidateTheCandidateByLastNameExistsInTheSearchResults(String lastName) {
       Assert.assertTrue(api.searchResultsForCurrentCandidate(lastName), "Candidate was not found in search results");
    }

    @Given("a request json {string} for updateContactInformation api with invite uuid")
    public void aRequestJsonForUpdateContactInformationApiWithInviteUuid(String file) throws IOException {

            if (api == null) {
                api = new BackendApi();
            }

            String uuid = Environment.getEnvironmentInviteUuid();
            Assert.assertNotNull(file, "FileName is null");
            Assert.assertNotEquals(file, "", "FileName is empty");
            Assert.assertNotNull(uuid, "Invite uuid is null");
            Assert.assertNotEquals(uuid, "", "Invite uuid is empty");

            testObject.processString(uuid);

            String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
            report("loading json from: " + file);
            report("content: " + content);
            api.setRequestContent(content);

            Response response = this.api.getResponse();
            String id = response.jsonPath().get("id").toString();
            report("id= "+id);

            api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/updateContactInformation/"+id);
        }

    @Given("a request json {string} for UpdateShippingInformation api")
    public void aRequestJsonForUpdateShippingInformationApi(String file) throws IOException {
        if (api == null) {
            api = new BackendApi();
        }


        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");


        String content = CommonMethods.readTextFile("src/test/resources/templates/" + file);
        report("loading json from: " + file);
        report("content: " + content);
        api.setRequestContent(content);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/updateShippingInformation/31be6fb8-fe4c-4f1f-be21-8105a0558df3");
    }

    @Given("a request for CreateOrder and POST to the api for reasonForTest PAC and REC Orders")
    public void aRequestForCreateOrderAndPOSTToTheApiForReasonForTestPACAndRECOrders(io.cucumber.datatable.DataTable dataTable) throws Exception {
        this.aRequestJsonForCreateOrderApi("WAOrderPA_RS.json");
        this.updateTheJsonRequest(dataTable);
        this.a_POST_call_is_sent_to_the_api();
        this.a_response_should_return_with_status("200");
        this.validateTheCreateOrderApiResponse();

        testObject.setRuntimeData(Constants.BACKEND_API, api);
    }

    @Given("a request for Support Tool and GET to the api")
    public void aRequestForSupportToolAndGETToTheApi() {
        if (api == null) {
            api = new BackendApi();
        }

        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/support/authorize");

        Response response=api.getGetResponse();
              report(response.toString());

    }

    @And("a request for Candidate and GET to the api")
    public void aRequestForCandidateAndGETToTheApi() {
        if (api == null) {
            api = new BackendApi();
        }

        Response response = this.api.getResponse();
        String id = response.jsonPath().get("inviteId").toString();
        report("inviteId= "+id);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/support/candidate/"+id);
        report("get endpoint: "+api.getEndpoint());
        Response response1=this.api.getGetResponse();
        report("Response: " + response1.getBody().asString());


    }

    @And("I search by candidate name {string} in the support tool")
    public void iSearchByCandidateNameInTheSupportTool(String name) {
        if (api == null) {
            api = new BackendApi();
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(date);
        report("date= "+today);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -14);
        String previous=formatter.format(calendar.getTime());
        report("previous= "+previous);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/support/candidates?start=0&size=40&sort.stepLastUpdated=DESC&filter.stepLastUpdated="+today+","+previous+"&search.name="+name);
        report("get endpoint: "+api.getEndpoint());
        Response response=this.api.getGetResponse();
        report("Response: " + response.getBody().asString());
    }

    @And("I search by device ID {string} in the support tool")
    public void iSearchByDeviceIDInTheSupportTool(String deviceID) throws ParseException {
        if (api == null) {
            api = new BackendApi();
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(date);
        report("date= "+today);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -14);
        String previous=formatter.format(calendar.getTime());
        report("previous= "+previous);
        api.setEndpoint(Environment.getEnvironmentBaseUrl() + "/api/support/candidates?start=0&size=40&sort.stepLastUpdated=DESC&filter.stepLastUpdated="+today+","+previous+"&search.deviceInformation="+deviceID);
        report("get endpoint: "+api.getEndpoint());
        Response response=this.api.getGetResponse();
        report("Response: " + response.getBody().asString());
    }

    @And("a request json {string} for Support Tool Patch api")
    public void aRequestJsonForSupportToolApi(String file) throws IOException {
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        if (api == null) {
            api = new BackendApi();
        }
        api.setSupportToolPatchOrder(file);
    }

    @Given("a request for CreateOrder and POST to the api for reasonForTest RND and businessLine Air Orders")
    public void aRequestForCreateOrderAndPOSTToTheApiForReasonForTestRNDAndBusinessLineAirOrders(io.cucumber.datatable.DataTable dataTable) throws Exception {
        this.aRequestJsonForCreateOrderApi("WAOrderRndAIRNonAdj.json");
        this.updateTheJsonRequest(dataTable);
        this.a_POST_call_is_sent_to_the_api();
        this.a_response_should_return_with_status("200");
        this.validateTheCreateOrderApiResponse();

        testObject.setRuntimeData(Constants.BACKEND_API, api);
    }

    @And("a request json {string} for UpdateCandidateEmailFlag api")
    public void aRequestJsonForUpdateCandidateEmailFlagApi(String file) throws IOException {
        Assert.assertNotNull(file, "FileName is null");
        Assert.assertNotEquals(file, "", "FileName is empty");
        if (api == null) {
            api = new BackendApi();
        }
        api.updateCanidateEmailFlag(file);
    }
}



