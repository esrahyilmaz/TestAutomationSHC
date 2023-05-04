package com.fadv.automation.rest;

import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.utils.CommonMethods;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author phamlong
 */
public class RestApi extends BaseClass {
    static Logger logger = Logger.getLogger(RestApi.class.getName());

    protected String requestContent;
    protected String endpoint;
    protected Response response;
    protected Map<String, String> headers;
    protected Map<String, ?> cookies;


    public static enum Method {
        GET, POST, PUT, PATCH
    }

    public String getRequestContent() {
        return requestContent;
    }

    public JsonNode getRequestJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(requestContent);
        return jsonNode;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Response getResponse() {
        return response;
    }

    public RestApi() {}

    public RestApi(String endpoint) {
        this.endpoint = endpoint;
    }

    public RestApi(TestObject to) {
        super(to);
    }

    public Map<String, ?> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, ?> cookies) {
        this.cookies = cookies;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * set header to send
     * @param headers
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
        report("set "+headers);
    }

    /**
     *
     * @param type
     * @param endpoint
     * @param requestContent
     * @return
     */
    public Response sendRequest(Method type, String endpoint, String requestContent) throws IOException {
        this.endpoint = endpoint;
        this.requestContent = requestContent;
        return sendRequest(type);
    }

    /**
     *
     * @param type
     * @return
     */
    public Response sendRequest(Method type) {
        RequestSpecification ra = RestAssured.given().contentType(ContentType.JSON);

        if (headers != null && !headers.isEmpty()){
            ra = ra.headers(map2Headers(headers));
        }

        try {
            if (cookies == null || cookies.isEmpty()){
                String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\cookies.json";
                Object c = CommonMethods.jsonFile2Object(file);
                cookies = (Map<String, ?>)c;
                ra = ra.cookies(cookies);
            } else {
                ra = ra.cookies(cookies);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        if (requestContent != null && !requestContent.isEmpty()) {
            logger.info("requestContent : " + requestContent);
        }

        switch (type) {
            case GET:
                response = (Response) ra.when().get(endpoint);
                return response;
//                if (headers != null && !headers.isEmpty()){
//                    response = RestAssured.given().headers(map2Headers(headers)).contentType(ContentType.JSON).body(requestContent).when().get(endpoint, new Object[0]);
//                    return response;
//                } else {
//                    response = (Response) RestAssured.given().contentType(ContentType.JSON).when().get(endpoint);
//                    return response;
//                }
            case POST:
                response = ra.body(requestContent).when().post(endpoint, new Object[0]);
                return response;

/*                if (cookies == null || cookies.isEmpty()){
                    String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\cookies.json";
                    Object c = null;
                    try {
                        c = CommonMethods.jsonFile2Object(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    cookies = (Map<String, ?>)c;
                    //ra = ra.cookies(cookies);

                    response = RestAssured.given().contentType(ContentType.JSON).cookies(cookies).body(requestContent).when().post(endpoint, new Object[0]);
                    return response;
                }
                return null;*/

//                if (headers != null && !headers.isEmpty()){
//                    response = RestAssured.given().headers(map2Headers(headers)).contentType(ContentType.JSON).body(requestContent).when().post(endpoint, new Object[0]);
//                    return response;
//                } else {
//                    response = RestAssured.given().contentType(ContentType.JSON).body(requestContent).when().post(endpoint, new Object[0]);
//                    return response;
//                }
            case PUT:
                response = ra.body(requestContent).when().put(endpoint, new Object[0]);
                return response;
//                if (headers != null && !headers.isEmpty()){
//                    response = RestAssured.given().headers(map2Headers(headers)).contentType(ContentType.JSON).body(requestContent).when().put(endpoint, new Object[0]);
//                    return response;
//                } else {
//                    response = RestAssured.given().contentType(ContentType.JSON).body(requestContent).when().put(endpoint, new Object[0]);
//                    return response;
//                }
            case PATCH:
                response = ra.body(requestContent).when().patch(endpoint, new Object[0]);
                return response;
            default:
                throw new RuntimeException("Method type [" + type + "] not support");
        }
    }

    /**
     *
     * @param values
     */
    public void updateRequestContentByJsonPathValues(Map<String, String> values) {
        Configuration configuration = Configuration.builder()
                .jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .build();
        DocumentContext context = JsonPath.using(configuration).parse(this.requestContent);
        for (Map.Entry<String,String> entry : values.entrySet()) {
            context.set(entry.getKey(), entry.getValue());
        }
        this.requestContent = context.jsonString();
    }

    public static Headers map2Headers(Map<String, String> data){
        if (data != null && !data.isEmpty()){
            List<Header> headers = new ArrayList<Header>();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                Header h = new Header(entry.getKey(), entry.getValue());
                headers.add(h);
            }
            return new Headers(headers);
        }
        return null;
    }
}
