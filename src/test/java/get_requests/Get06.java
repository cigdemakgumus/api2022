package get_requests;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/555
    When
    User send a GET request to the URL
    Then
    HTTP Status Code should be 200
    And
    Response content type is “application/json”
    And
    Response body should be like;
    {
        "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
        "checkin": "2013-02-23",
                "checkout": "2014-10-23"
    },
        "additionalneeds": "Breakfast"
    }
     */
    @Test
    public void get01(){
        //1.Step: Set the Url
        spec.pathParams("first","booking","second",101);

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
        body("firstname",equalTo("GGS"),"lastname",equalTo("FINCH"),"totalprice",equalTo(111),
                "depositpaid",equalTo(true),
                "bookingdates.checkin",equalTo("2018-01-01"),
                "bookingdates.checkout",equalTo("2019-01-01"));

        //2. Yol: JsonPath Class kullanılır

        JsonPath json=response.jsonPath();
        assertEquals("EEG", json.getString("firstname"));
        assertEquals("FINCH",json.getString("lastname"));
        assertEquals(111,json.getInt("totaiprice"));
        assertEquals("true",json.getBoolean("depositpaid"));
        assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));



    }
}
