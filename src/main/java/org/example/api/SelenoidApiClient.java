package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SelenoidApiClient {

    public static final String SELENOID_VIDEO_URL = "http://localhost:4444/video";

    public byte[] getVideo(String videoFileName) {
        Response response = RestAssured.given()
                .baseUri(SELENOID_VIDEO_URL)
                .accept("*/*")
                .get(videoFileName);
        return response.body().asByteArray();
    }
}
