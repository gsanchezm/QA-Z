package com.titanium.framework.api.utils;

import com.titanium.framework.general.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredUtils {

    public static RequestSpecification request;

    public RestAssuredUtils(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(PropertyManager.getInstance().getProperty("Api_Url"));
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> getWithPathParameters(String endpoint, Map<String, String> pathParams){
        request.pathParams(pathParams);
        return request.get(endpoint);
    }

    public static ResponseOptions<Response> getWithQueryParameters(String url, String queryParams){
        try {
            request.queryParam(queryParams);
            return request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> getOptions(String url){
        try {
            return request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> postWithBodyAndPathParams(String endpoint, Map<String, String> pathParams, Map<String, String> body) {
        request.pathParams(pathParams);
        request.body(body);
        return request.post(endpoint);
    }

    public static ResponseOptions<Response> postWithBody(String endpoint, Map<String, String> body) {
        request.body(body);
        return request.post(endpoint);
    }

    public static ResponseOptions<Response> deleteWithPathParams(String endpoint, Map<String, String> pathParams){
        request.pathParams(pathParams);
        return request.delete(endpoint);

    }

    public static ResponseOptions<Response> putWithBody(String endpoint, Map<String, String> body) {
        request.body(body);
        return request.put(endpoint);
    }

    public static ResponseOptions<Response> puttWithBodyAndPathParams(String endpoint, Map<String, String> pathParams, Map<String, String> body) {
        request.pathParams(pathParams);
        request.body(body);
        return request.put(endpoint);
    }
}
