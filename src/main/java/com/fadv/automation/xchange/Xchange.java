package com.fadv.automation.xchange;

import com.aventstack.extentreports.Status;
import com.fadv.automation.Constants;
import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.environment.EspEnv;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.with;


/**
 * @author phamlong
 */
public class Xchange extends BaseClass {
    public Xchange(TestObject to) {
        super(to);
    }

    private String url = null;
    private String content = null;
    private Response response = null;

    public Xchange url(String url) {
        this.url = url;
        return this;
    }

    public Xchange content(String content) {
        this.content = content;
        return this;
    }

    public int getResponseCode(){
        return response.statusCode();
    }

    public String getOrderIDFromResponse(){
        return with(response.asString()).get("BackgroundReports.BackgroundReportPackage.ProviderReferenceId");
    }


    public String getPostUrl(String type) {
        String baseUrl;
        EspEnv env = (EspEnv) testObject.getTestEnv();
        if (env == null){
            baseUrl = "https://ua.enterprisetest.fadv.com";
        }
        else {
            baseUrl = env.getEAUrl();
        }
        if (type.equalsIgnoreCase(Constants.XCHANGE_1STEP)) {
            return baseUrl + "pub/xchange/order";
        } else if (type.equalsIgnoreCase(Constants.XCHANGE_2STEP)) {
            return baseUrl + "pub/xchange/startOrder";
        } else if (type.equalsIgnoreCase("StatusRequest")) {
            return baseUrl + "pub/xchange/status";
        } else if (type.equalsIgnoreCase("LinkRequest")) {
            return baseUrl + "pub/xchange/link";
        } else if (type.equalsIgnoreCase("Admin")) {
            return baseUrl + "pub/xchange/admin";
        } else if (type.equalsIgnoreCase("CandidateInvitation")) {
            return baseUrl + "pub/xchange/rest/CandidateInvitationsService/SendCandidateInvitations";
        } else if (type.equalsIgnoreCase("CandidateLink")) {
            return baseUrl + "pub/xchange/candidateLink";
        } else if (type.equalsIgnoreCase("instantBackgroundCheck")) {
            return baseUrl + "pub/xchange/instantBackgroundCheck";
        } else if (type.equalsIgnoreCase("resellerOrder")) {
            return baseUrl + "pub/xchange/resellerOrder";
        } else if (type.equalsIgnoreCase("addSearch")) {
            return baseUrl + "pub/xchange/addSearch";
        }
        return null;
    }

    /**
     *
     * @param type
     * @return
     */
    public Response sendAs(String type) {
        url = getPostUrl(type);

        report("Post URL:" + url);
        report("Request: " + content);

        response = this.sendRequest(this.content, this.url);
        testObject.setRuntimeData(Constants.XCHANGE_RESPONSE, response);
        testObject.setRuntimeData(Constants.XCHANGE_RESPONSE_STRING, response.asString());

        report("Response: " + response.asString());

        if (type.equalsIgnoreCase(Constants.XCHANGE_1STEP)) {
            String orderString = with(response.asString()).get("BackgroundReports.BackgroundReportPackage.ProviderReferenceId");
            if (orderString != null) {
                String[] splits = orderString.split("-");
                testObject.setRuntimeData(Constants.CID, splits[1]);
                testObject.setRuntimeData(Constants.ORDER_STRING, orderString);

                report(Status.INFO, "CID : " + splits[1]);
            }
        }

        return response;
    }

    public Response sendRequest(String xmlContent, String url) {
        Response response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body(xmlContent)
                .when()
                .post(url);
        return response;
    }

    public static void main(String[] args) {
        //   PropertyConfigurator.configure(System.getProperty("user.dir")+ File.separator + "log4j.properties");

//        TestObject test = TestObject.get(null);
//       // test.setEnvironment(new EspEnv(EspEnv.QAA));
//
//        Xchange comp = new Xchange(test);
//        comp.sendRequest();
    }
}