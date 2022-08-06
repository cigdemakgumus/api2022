package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01{
    /*
    1) Postman manuel API testi icin kullanilir.
    2) API Otomaston testi icin Rest-Assured Library kullaniyoruz
    3) Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
        a) Gereksinimleri anlama - understanging requirement
        b) Test case'i yazma
            i) Test case yazimi icin 'Gherkin Language' kullaniriz
                Gherkin  bazi keywordlere sahip, bunlar:
                x) Given: on kosullar
                y) When : yapacagimiz actionlar --> Get, Put, Delete gibi
                z) Then : Donutler --> Dogrulama, response ....
                t) And : Coklu islemler icin kullanilir

c) -->  Otomasyonda test kodunun yazımı yapılacak
        1) Set the URL (URl'yi kurmak)
        2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""
        3) Type code to send request (talep göndermek için kod yazma)
        4) Do Assertion (doğrulama yapma)
     */
  /*  Given
    https://restful-booker.herokuapp.com/booking/3
    When
    User sends a GET Request to the url
    Then
    HTTP Status Code should be 200
    And
    Content Type should be JSON
            And
    Status Line should be HTTP/1.1 200 OK
*/
    @Test
    public void Get01(){
        // 1) Set the URL (URl'yi kurmak)
        String url ="https://restful-booker.herokuapp.com/booking/162";
        //  2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""
        //  3) Type code to send request (talep göndermek için kod yazma)
        Response response=given().when().get(url);
        response.prettyPrint();
        //   4) Do Assertion (doğrulama yapma)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        //status code nasil yazdirilir:
        System.out.println("StatusCode= " + response.statusCode());
        //Contenttype nasil yazdirilir:
        System.out.println("ContentType= " + response.contentType());
        //Status line nasil yazdirilir:
        System.out.println("StatusLine = " + response.statusLine());
        //Header nasil yazdirilir:
        System.out.println(response.header("Connection"));
        //Headers nasil yazdirilir:
        System.out.println("Headers :\n" + response.headers());
        //Time nasil yazdirilir:
        System.out.println("Time() = " + response.getTime());
        System.out.println("size "+response.headers().size());

    }
}